package com.devoxxpl.deployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.devoxxpl.deployment"})
@EntityScan(basePackages = "com.devoxxpl.database.entity") //for initializing the database using import.sql
public class FrameworkAgnosticDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkAgnosticDemoApplication.class, args);
    }
}
