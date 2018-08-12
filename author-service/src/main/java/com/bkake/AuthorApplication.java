package com.bkake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class AuthorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorApplication.class, args);
    }
}
