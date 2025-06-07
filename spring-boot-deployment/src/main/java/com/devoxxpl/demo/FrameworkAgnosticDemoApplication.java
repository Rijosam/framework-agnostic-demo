package com.devoxxpl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.devoxxpl"})
@EnableJpaRepositories(basePackages = "com.devoxxpl.database.repository")
@EntityScan(basePackages = "com.devoxxpl.database.entity")
public class FrameworkAgnosticDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkAgnosticDemoApplication.class, args);
    }
}
