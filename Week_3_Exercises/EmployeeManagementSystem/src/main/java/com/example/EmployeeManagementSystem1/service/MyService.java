package com.example.EmployeeManagementSystem1.service;

import com.example.EmployeeManagementSystem1.Employee;
import com.example.EmployeeManagementSystem1.projection.EmployeeDTO;
import com.example.EmployeeManagementSystem1.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem1.repository.EmployeeRepository;
import com.example.EmployeeManagementSystem1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void addEmployee(String name, String email, Long departmentId) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setDepartment(departmentRepository.findById(departmentId).orElse(null));
        employeeRepository.save(employee);
    }

    public Page<Employee> getPaginatedAndSortedEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Page<Employee> getEmployeesByNameWithPaginationAndSorting(String name, Pageable pageable) {
        return employeeRepository.findByNameContaining(name, pageable);
    }

    public List<EmployeeProjection> getEmployeeProjections() {
        return employeeRepository.findAllEmployeeProjections();
    }

    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeRepository.findAllEmployeeDTOs();
    }
}
