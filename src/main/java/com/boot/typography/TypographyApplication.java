package com.boot.typography;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.boot.typography.repository"})
@EntityScan("com.boot.typography")
public class TypographyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TypographyApplication.class, args);
    }

}
