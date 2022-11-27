package cn.itcast.eureka;/*
 *
 * @Param
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

@EnableEurekaServer //自动注解的开关
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
/**
 * 1、搭建EurekaServer
 *     ·引入eureka-server依赖
 *     ·添加@EnableEurekaServer注解
 *     ·在application.yml中配置eureka地址
 *
 * 2.服务注册
 *     ·引入eureka-clint依赖
 *     ·在application.yml中配置eureka地址
 *
 * 3.服务发现
 *     ·引入eureka-clint依赖
 *     ·在application.yml中配置eureka地址
 *     ·给RestTemplate添加LoadBalanced注解
 *     ·用服务者提供的服务为名称远程调用
 */