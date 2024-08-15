package com.example.EmployeeManagementSystem1.repository;

import com.example.EmployeeManagementSystem1.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByName(String name);

    @Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
    List<Department> findDepartmentsByNamePattern(@Param("name") String name);
}
