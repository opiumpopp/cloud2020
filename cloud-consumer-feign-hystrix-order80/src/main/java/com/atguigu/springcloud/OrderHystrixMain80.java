package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author opiumpopp
 * @create 2020-10-08
 */
@SpringBootApplication
@EnableFeignClients
public class OrderHystrixMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}