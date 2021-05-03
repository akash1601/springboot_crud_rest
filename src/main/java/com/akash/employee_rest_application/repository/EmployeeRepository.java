package com.akash.employee_rest_application.repository;

import com.akash.employee_rest_application.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
