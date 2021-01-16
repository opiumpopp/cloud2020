package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author opiumpopp
 * @create 2021-01-16
 */
@Configuration
@MapperScan({"com.atguigu.springcloud.alibaba.mapper"})
public class MyBatisConfig {

}