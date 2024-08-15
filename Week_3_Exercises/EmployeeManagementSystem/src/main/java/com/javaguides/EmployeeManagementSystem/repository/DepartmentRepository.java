package com.javaguides.EmployeeManagementSystem.repository;

import com.javaguides.EmployeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.*;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@SuppressWarnings("unused")
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    // Derived query method to find departments by name
    @Query("SELECT d FROM Department d WHERE d.name=:name")
    Department findByName(@Param("name")String name);

    @Query(value = "SELECT * FROM departments d WHERE d.name LIKE %:pattern%", nativeQuery = true)
    List<Department> findByNamePattern(@Param("pattern") String pattern);
}
