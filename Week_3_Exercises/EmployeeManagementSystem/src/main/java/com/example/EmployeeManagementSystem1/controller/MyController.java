package com.example.EmployeeManagementSystem1.controller;

import com.example.EmployeeManagementSystem1.Employee;
import com.example.EmployeeManagementSystem1.projection.EmployeeDTO;
import com.example.EmployeeManagementSystem1.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem1.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/addEmployee")
    public String addEmployee(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Long departmentId) {
        myService.addEmployee(name, email, departmentId);
        return "Employee added successfully";
    }

    @GetMapping("/getEmployeesByName")
    public Page<Employee> getEmployeesByName(
            @RequestParam String name,
            Pageable pageable) {
        return myService.getEmployeesByNameWithPaginationAndSorting(name, pageable);
    }

    @GetMapping("/getPaginatedEmployees")
    public Page<Employee> getPaginatedEmployees(Pageable pageable) {
        return myService.getPaginatedAndSortedEmployees(pageable);
    }

    @GetMapping("/employeeProjections")
    public List<EmployeeProjection> getEmployeeProjections() {
        return myService.getEmployeeProjections();
    }

    @GetMapping("/employeeDTOs")
    public List<EmployeeDTO> getEmployeeDTOs() {
        return myService.getEmployeeDTOs();
    }
}
