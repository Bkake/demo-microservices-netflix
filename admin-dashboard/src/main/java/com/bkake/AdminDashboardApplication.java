package com.bkake;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
@RefreshScope
public class AdminDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminDashboardApplication.class, args);
    }
}
