package com.javaguides.EmployeeManagementSystem.entity;


import java.time.LocalDateTime;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.javaguides.EmployeeManagementSystem.entity.Department;

import static jakarta.persistence.TemporalType.TIMESTAMP;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Entity
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByDepartment",
        query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName"
    ),
    @NamedQuery(
        name = "Employee.findAllOrderByName",
        query = "SELECT e FROM Employee e ORDER BY e.name ASC"
    )
})

// @Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Employee extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Temporal(TIMESTAMP)
    @Column(nullable = false)
    private String lastModifiedBy;

    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    private Department department;

    // Constructors, getters, setters
    public Employee(){
        this.id=(long) 0;
        this.name=null;
        this.email=null;
    }
    public Employee(String name, String email, Department department){
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
