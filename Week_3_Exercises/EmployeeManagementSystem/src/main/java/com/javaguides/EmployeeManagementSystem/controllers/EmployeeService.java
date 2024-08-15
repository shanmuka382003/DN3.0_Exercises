package com.javaguides.EmployeeManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaguides.EmployeeManagementSystem.projections.EmployeeNameEmailDTO;
import com.javaguides.EmployeeManagementSystem.projections.EmployeeNameEmailProjection;
import com.javaguides.EmployeeManagementSystem.projections.EmployeeNameWithDomainProjection;
import com.javaguides.EmployeeManagementSystem.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public List<EmployeeNameEmailProjection> getEmployeeNamesAndEmails() {
        return employeeRepository.findAllBy();
    }

    public List<EmployeeNameEmailDTO> getEmployeeDTOs(){
        return employeeRepository.findAllEmployeeNamesandEmails();
    }

    public List<EmployeeNameWithDomainProjection> getEmployeeNameWithDomain(){
        return employeeRepository.findAllNameWithDomain();
    }
}
