package com.akash.employee_rest_application.service;

import com.akash.employee_rest_application.exception.ResourceNotFoundException;
import com.akash.employee_rest_application.model.Employee;
import com.akash.employee_rest_application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class EmployeeServiceImp implements EmployeeServicee{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employee.getId());
        if (employeeDb.isPresent()) {
            Employee employeeUpdate = employeeDb.get();
            employeeUpdate.setId(employee.getId());
            employeeUpdate.setName(employee.getName());
            employeeUpdate.setDepartment(employee.getDepartment());
            employeeUpdate.setSalary(employee.getSalary());
            return employeeUpdate;
        }else{
            throw new ResourceNotFoundException("Resource not found" + employee.getId());
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(id);
        if (employeeDb.isPresent()) {
            return employeeDb.get();
        } else{
            throw new ResourceNotFoundException("Resource not found" + id);
        }
    }

    @Override
    public void deleteEmployee(long id) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(id);
        if (employeeDb.isPresent()) {
            this.employeeRepository.delete(employeeDb.get());
        } else{
            throw new ResourceNotFoundException("Resource not found" + id);
        }
    }

}
