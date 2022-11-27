package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    //属性注入方式一：热更新需要给属性所在类加上注解@RefreshScope
//    @Value("${pattern.dateformat}")
//    private String dateformat;

    //属性注入方式二：热更新需要加入注解@ConfigurationProperties(prefix = "")
    @Autowired
    private PatternProperties patternProperties;
    /**
     * 获取envSharedValue
     */
    @GetMapping("prop")
    public PatternProperties envSharedValue(){
        return patternProperties;
    }
    /**
     * 获取当前时间
     * @return
     */
    @GetMapping("/now")
    public String now(@RequestHeader(value = "Truth",required = false) String Truth){
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
        format += "\n" + Truth;
        return format;
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
