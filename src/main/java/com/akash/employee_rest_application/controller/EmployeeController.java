package com.akash.employee_rest_application.controller;

import com.akash.employee_rest_application.model.Employee;
import com.akash.employee_rest_application.service.EmployeeServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServicee employeeServicee;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeServicee.getAllEmployee());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getProductById(@PathVariable long id){
        return ResponseEntity.ok().body(employeeServicee.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createProduct(@RequestBody Employee employee){
        return ResponseEntity.ok().body(this.employeeServicee.addEmployee(employee));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateProduct(@PathVariable long id, @RequestBody Employee employee){
        employee.setId(id);
        return ResponseEntity.ok().body(this.employeeServicee.updateEmployee(employee));
    }

    @DeleteMapping("/employees/{id}")
    public HttpStatus deleteProduct(@PathVariable long id){
        this.employeeServicee.deleteEmployee(id);
        return HttpStatus.OK;
    }
}