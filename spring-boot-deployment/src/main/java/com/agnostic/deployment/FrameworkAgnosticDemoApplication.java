package com.agnostic.deployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.agnostic"})
@EntityScan(basePackages = "com.agnostic.database")
public class FrameworkAgnosticDemoApplication {

    static void main(String[] args) {
        SpringApplication.run(FrameworkAgnosticDemoApplication.class, args);
    }
}
