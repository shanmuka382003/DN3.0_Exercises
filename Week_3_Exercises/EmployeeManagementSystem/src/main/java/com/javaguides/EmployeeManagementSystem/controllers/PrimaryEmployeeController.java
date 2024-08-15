package com.javaguides.EmployeeManagementSystem.controllers;

import com.javaguides.EmployeeManagementSystem.entity.PrimaryEmployee;
import com.javaguides.EmployeeManagementSystem.service.PrimaryEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/primary-employees")
public class PrimaryEmployeeController {

    @Autowired
    private PrimaryEmployeeService primaryEmployeeService;

    @GetMapping
    public List<PrimaryEmployee> getAllEmployees() {
        return primaryEmployeeService.getAllEmployees();
    }

    @PostMapping
    public PrimaryEmployee createEmployee(@RequestBody PrimaryEmployee employee) {
        return primaryEmployeeService.saveEmployee(employee);
    }

}
