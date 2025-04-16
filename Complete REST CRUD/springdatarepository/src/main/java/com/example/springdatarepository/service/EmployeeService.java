package com.example.springdatarepository.service;

import com.example.springdatarepository.entity.Employee;

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
