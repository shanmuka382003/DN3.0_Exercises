package com.javaguides.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides.EmployeeManagementSystem.entity.PrimaryEmployee;

public interface PrimaryEmployeeRepository extends JpaRepository<PrimaryEmployee, Long> {
    
}
