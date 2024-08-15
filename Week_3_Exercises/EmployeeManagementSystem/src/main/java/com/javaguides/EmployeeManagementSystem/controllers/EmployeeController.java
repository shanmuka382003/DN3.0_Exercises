package com.javaguides.EmployeeManagementSystem.controllers;

import com.javaguides.EmployeeManagementSystem.entity.Employee;
import com.javaguides.EmployeeManagementSystem.entity.Department;
import com.javaguides.EmployeeManagementSystem.projections.EmployeeNameEmailProjection;
import com.javaguides.EmployeeManagementSystem.projections.EmployeeNameWithDomainProjection;
import com.javaguides.EmployeeManagementSystem.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @GetMapping("/test")
    public String testEndpoint() {
        return "EmployeeControleer is working";
    }
    

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new Employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        System.out.println("name" + employee.getName());
        System.out.println("name" + employee.getDepartment());

        Employee employee2 = new Employee();
        employee2.setEmail(employee.getEmail());
        employee2.setName(employee.getName());
        return employeeRepository.save(employee);
    }

    // Get all Employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // Get a single Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    // Update an Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee == null) {
            return ResponseEntity.notFound().build();
        }
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete an Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        employeeRepository.delete(employee);
        return ResponseEntity.noContent().build();
    }

    // namedquery by name
    @GetMapping("/by-name/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        return employeeRepository.findByName(name);
    }

    // named query by email
    @GetMapping("/by-email/{email}")
    public Employee getEmployeesByEmail(@PathVariable String email) {
        return employeeRepository.findByEmail(email);
    }

    // named query by department
    @GetMapping("/by-department-name/{departmentName}")
    public List<Employee> getEmployeesByDepartmentName(@PathVariable String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }

    @GetMapping("/api/employees/paged")
    public Page<Employee> getAllEmployees(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sortBy) {
            Pageable pageable = PageRequest.of(page,size,Sort.by(sortBy));
            return employeeRepository.findAll(pageable);
        }
    
    // Testing projections
    @GetMapping("/empprojection")
	    public List<EmployeeNameEmailProjection> getAllEmployeesByProjection(){
	    	return employeeRepository.findByEmployee();
	    }
	    @GetMapping("/empprojbyvalue/{departmentName}")
	    public List<EmployeeNameWithDomainProjection> getByDepartmentName1(@PathVariable String departmentName){
	    	return employeeRepository.findByDepartmentName1(departmentName);
	    }
}
