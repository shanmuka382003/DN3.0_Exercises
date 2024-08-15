package com.javaguides.EmployeeManagementSystem.repository;

import com.javaguides.EmployeeManagementSystem.entity.Employee;
import com.javaguides.EmployeeManagementSystem.projections.EmployeeNameEmailDTO;
import com.javaguides.EmployeeManagementSystem.projections.EmployeeNameEmailProjection;
import com.javaguides.EmployeeManagementSystem.projections.EmployeeNameWithDomainProjection;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

// import com.javaguides.EmployeeManagementSystem.entity.Employee;
import java.util.*;

@SuppressWarnings("unused")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {
    
    // Derived query method to find employees by name
    List<Employee> findByName(String name);
    
    // Derived query method to find employees by department name
    List<Employee> findByDepartmentName(String departmentName);

    // Custom query to find employees by email
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email") String email);

    // Custome query to find employees by department id
    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId")
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);

    // Using named query findByDepartment
    @Query(name = "Employee.findByDepartment")
    List<Employee> findByDepartment(@Param("departmentName") String departmentName);

    // Using named query findAllOrderByName
    @Query(name = "Employee.findAllOrderByName")
    List<Employee> findAllOrderByName();

    // Interface-based projection
    List<EmployeeNameEmailProjection> findAllBy();

    // Class-based projection using constructor expressions
    @Query("SELECT new com.javaguides.projections.EmployeeNameEmailDTO(e.name, e.email) FROM Employee e")
    List<EmployeeNameEmailDTO> findAllEmployeeNamesandEmails();

    // @Value-based projection
    @Query("SELECT e FROM Employee e")
    List<EmployeeNameWithDomainProjection> findAllNameWithDomain();

    @Query("SELECT e.name AS name, e.email AS email, " +
           "CONCAT(e.name, ' (', SUBSTRING(e.email, LOCATE('@', e.email) + 1), ')') AS displayName " +
           "FROM Employee e")
    List<EmployeeNameEmailProjection> findAllProjectedBy();

    //adding the query for employee projection
	
	@Query("SELECT e.name as name,e.email as email FROM Employee e")
	List<EmployeeNameEmailProjection> findByEmployee();
	
	//adding the query for employee projection by value
	@Query("SELECT e.name as name,e.email as email FROM Employee e WHERE e.department.name =:departmentName")
	List<EmployeeNameWithDomainProjection>findByDepartmentName1(@Param("departmentName") String departmentName);

    Page<Employee> findall(Pageable pageable);
}
