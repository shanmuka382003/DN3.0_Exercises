package com.example.EmployeeManagementSystem1.repository;

import com.example.EmployeeManagementSystem1.Employee;
import com.example.EmployeeManagementSystem1.projection.EmployeeDTO;
import com.example.EmployeeManagementSystem1.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByEmailContaining(String email);

    List<Employee> findByDepartmentName(String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email") String email);

    @Query("SELECT e.name as name, e.email as email FROM Employee e")
    List<EmployeeProjection> findAllEmployeeProjections();

    @Query("SELECT new com.example.EmployeeManagementSystem1.projection.EmployeeDTO(e.name, e.email) FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTOs();

    Page<Employee> findByNameContaining(String name, Pageable pageable);
}
