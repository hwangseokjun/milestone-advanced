package com.sparta.milestone03advanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Milestone03AdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(Milestone03AdvancedApplication.class, args);
    }

}
