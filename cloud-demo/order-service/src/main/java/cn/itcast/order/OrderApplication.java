package cn.itcast.order;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//开启Feign的能力     Feign日志全局配置，则把它放到@EnableFeignClients这个注解
//当定义的FeignClient不在SpringBootApplication的扫描包范围时，这些FeignClient无法使用。有两种方式解决:
//@EnableFeignClients(basePackages = "cn.itcast.feign.clients") //方法一
@EnableFeignClients(clients = {UserClient.class},defaultConfiguration = DefaultFeignConfiguration.class) //方法二
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * spring提供的用于发送http请求的
     * @LoadBalanced : 说明RestTemplate发出的请求会被Ribbon负载均衡所拦截，然后在Eureka-server注册中心中拉取
     * @return
     */
    @Bean
    @LoadBalanced //负载均衡注解
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 修改负载均衡的方式
     * 方式一：在OrderApplication中配置一个新的IRule（针对全局）
     * 方式二：配置文件方式：在order-service的application.yml中，添加新的配置（只针对配置文件所在的微服务）
     * @return
     */
    //@Bean
//    public IRule randomRule(){
//        //将负载均衡的策略设置为了随机
//        return new RandomRule();
//    }

}