package cn.itcast.feign.config;/*
 *
 * @Param
 */

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 配置Feign日志的方式二
 * 而后如果是全局配置，则把它放到@EnableFeignClients这个注解中
 * 如果是局部配置，则把它放到@FeignClient这个注解中：
 */

public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC;
    }
}
