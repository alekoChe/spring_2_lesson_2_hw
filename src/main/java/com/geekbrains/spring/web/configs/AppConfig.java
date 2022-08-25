package com.geekbrains.spring.web.configs;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("secrets.properties")
public class AppConfig {
}
