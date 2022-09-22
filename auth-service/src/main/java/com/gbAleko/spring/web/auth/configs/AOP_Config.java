package com.gbAleko.spring.web.auth.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  ////////////////////////
@ComponentScan("com.gbAleko.spring.web.auth.aop")
public class AOP_Config {
}
