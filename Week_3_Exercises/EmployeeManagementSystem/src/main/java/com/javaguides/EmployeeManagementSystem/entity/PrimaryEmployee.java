package com.javaguides.EmployeeManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PrimaryEmployee {
    @Id
    private Long id;
    private String name;
    private String email;

    // Getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
