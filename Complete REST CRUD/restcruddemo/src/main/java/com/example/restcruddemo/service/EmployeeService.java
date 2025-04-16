package com.example.restcruddemo.service;

import com.example.restcruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

//    Method to list all employees
    List<Employee> findAll();

//    Find Employee by Id
    Employee findById(int id);

//    Update Employee
    Employee updateEmployee(Employee employee);

//    Save Employee
    Employee save(Employee employee);

//    Delete Employee
    void delete(int id);
}
