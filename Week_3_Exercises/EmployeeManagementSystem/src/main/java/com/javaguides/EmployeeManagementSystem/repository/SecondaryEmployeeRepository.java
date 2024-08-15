package com.javaguides.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides.EmployeeManagementSystem.entity.SecondaryEmployee;

public interface SecondaryEmployeeRepository extends JpaRepository<SecondaryEmployee, Long> {
    
}
