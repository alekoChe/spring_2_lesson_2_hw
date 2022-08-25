package com.geekbrains.spring.web;

import com.geekbrains.spring.web.configs.AOP_Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@EnableCaching
public class SpringWebApplication {
	// Домашнее задание:
	// Вспомнить\разобраться с кодом
	// Реализовать методы Cart, которые мы не реализовали на уроке

	public static void main(String[] args) {
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOP_Config.class); ////
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
