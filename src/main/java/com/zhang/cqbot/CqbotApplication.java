package com.zhang.cqbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zhang.cqbot")
public class CqbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqbotApplication.class, args);
    }

}
