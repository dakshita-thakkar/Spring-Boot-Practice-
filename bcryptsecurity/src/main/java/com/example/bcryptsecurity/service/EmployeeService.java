package com.example.bcryptsecurity.service;

import com.example.bcryptsecurity.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee);

    Object updateEmployee(Employee employee);

}
