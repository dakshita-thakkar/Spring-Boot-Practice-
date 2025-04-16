package com.example.restcruddemo.dao;

import com.example.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

//    Method to get all employees
    List<Employee> findAll();

//    Get an Employee by Id
    Employee findById(int id);

//    Insert Employee
    Employee save(Employee employee);

//    Update an Employee
    Employee updateEmployee(Employee employee);

//    Delete an Employee
    void delete(int id);
}
