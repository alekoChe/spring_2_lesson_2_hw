package com.geekbrains.spring.web.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  ////////////////////////
@ComponentScan("com.geekbrains.spring.web.aop")
public class AOP_Config {
}
