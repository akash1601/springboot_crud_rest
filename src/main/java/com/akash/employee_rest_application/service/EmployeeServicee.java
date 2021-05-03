package com.akash.employee_rest_application.service;

import com.akash.employee_rest_application.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeServicee {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long id);
    void deleteEmployee(long id);
}
