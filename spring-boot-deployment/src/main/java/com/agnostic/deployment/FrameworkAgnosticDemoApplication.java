package com.agnostic.deployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.agnostic"})
@EnableJpaRepositories(basePackages = "com.agnostic.database")
@EntityScan(basePackages = "com.agnostic.database")
public class FrameworkAgnosticDemoApplication {

    static void main(String[] args) {
        SpringApplication.run(FrameworkAgnosticDemoApplication.class, args);
    }
}
