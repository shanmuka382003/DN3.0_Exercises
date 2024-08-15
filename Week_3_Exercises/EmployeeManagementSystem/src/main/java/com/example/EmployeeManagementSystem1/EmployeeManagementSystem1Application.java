package com.example.EmployeeManagementSystem1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeManagementSystem1Application {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystem1Application.class, args);
    }
}

