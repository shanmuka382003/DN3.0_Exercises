package com.example.EmployeeManagementSystem1.service;

import com.example.EmployeeManagementSystem1.Employee;
import com.example.EmployeeManagementSystem1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<Employee> getEmployeesWithPaginationAndSorting(int page, int size, String[] sort) {
        Sort sortOrder = Sort.by(sort);
        Pageable pageable = PageRequest.of(page, size, sortOrder);
        return employeeRepository.findAll(pageable);
    }

    @Transactional
    public void bulkInsertEmployees(List<Employee> employees) {
        int batchSize = 50;
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }

    @Transactional
    public void bulkUpdateEmployees(List<Employee> employees) {
        int batchSize = 50;
        for (int i = 0; i < employees.size(); i++) {
            entityManager.merge(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
