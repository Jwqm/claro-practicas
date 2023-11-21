package com.example.springbootdemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.springbootdemo.mapper")
public class MyBatisConfig {
}
