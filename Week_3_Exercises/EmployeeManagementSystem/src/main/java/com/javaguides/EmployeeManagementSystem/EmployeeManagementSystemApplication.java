package com.javaguides.EmployeeManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.javaguides.EmployeeManagementSystem")
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {
    "com.javaguides.EmployeeManagementSystem.repository.primary",
    "com.javaguides.EmployeeManagementSystem.repository.secondary",
    "com.javaguides.EmployeeManagementSystem.repository" // Add your main repository package
})
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

}
