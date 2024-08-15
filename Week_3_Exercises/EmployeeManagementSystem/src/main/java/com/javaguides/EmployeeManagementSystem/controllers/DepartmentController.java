package com.javaguides.EmployeeManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.EmployeeManagementSystem.entity.Department;
import com.javaguides.EmployeeManagementSystem.repository.DepartmentRepository;
import com.javaguides.EmployeeManagementSystem.entity.Employee;
import com.javaguides.EmployeeManagementSystem.config.*;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.*;

@Service
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	// @Autowired
    private DepartmentRepository departmentRepository;

    // Constructor-based dependency injection
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

   // @Transactional("secondaryTransactionManager")
	
	@GetMapping(value="test")
	public String test() {
		return "Welcome to Spring Boot API"; 
	}
	@PostMapping("/bulkadd")
    public String insertDepartments() { 
    
    	Department d1 = new Department((long) 0,"test");
    	Department d2 = new Department((long) 0,"test1");
    	Department d3 = new Department((long) 0,"test2");
    	Department d4 = new Department((long) 0,"test3");
    	
        List<Department> departments = Arrays.asList(d1, d2, d3, d4);
        // departmentRepository.saveAllAndFlush(departments);
        return "inserted successfully";
    }
	@PostMapping(value="add")
	public Department addDepartment(@RequestBody Department department)
	{
		return departmentRepository.save(department);
	}
	@GetMapping(value="/")
	public List<Department> getDepartment()
	{
		return departmentRepository.findAll();
	}
//	
	@GetMapping(value="/name/{name}")
	public Department getAllDepartmentByName(@PathVariable String name)
	{
		return departmentRepository.findByName(name);
	}
	@GetMapping(value="/pattern/{pattern}")
	public List<Department> getAllDepartmentByPattern(@PathVariable String pattern)
	{
		return departmentRepository.findByNamePattern(pattern);
	}
}
// public class DepartmentController {
//     @Autowired
//     private DepartmentRepository departmentRepository;

//     @GetMapping(value = "test")
//     public String test() {
//         return "Hello, World! Welcome to Spring Boot API";
//     }

//     // Create a new Department
//     @PostMapping
//     public Department createDepartment(@RequestBody Department department) {
//         return departmentRepository.save(department);
//     }

//     // Get all Departments
//     @GetMapping
//     public List<Department> getAllDepartments() {
//         return departmentRepository.findAll();
//     }

//     // Get a single Department by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
//         Department department = departmentRepository.findById(id).orElse(null);
//         if (department != null) {
//             return ResponseEntity.notFound().build();
//         }
//         return ResponseEntity.ok(department);
//     }

//     // Update a Department
//     @PutMapping("/{id}")
//     public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
//         Department department = departmentRepository.findById(id).orElse(null);
//         if (department == null) {
//             return ResponseEntity.notFound().build();
//         }
//         department.setName(departmentDetails.getName());
//         Department updatedDepartment = departmentRepository.save(department);
//         return ResponseEntity.ok(updatedDepartment);
//     }

//     // Delete a Department
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
//         Department department = departmentRepository.findById(id).orElse(null);
//         if(department == null){
//             return ResponseEntity.notFound().build();
//         }
//         departmentRepository.delete(department);
//         return ResponseEntity.noContent().build();
//     }
    
// }
