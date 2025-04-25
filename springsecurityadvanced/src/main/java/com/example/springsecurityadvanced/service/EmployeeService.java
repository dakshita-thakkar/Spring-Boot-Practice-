package com.example.springsecurityadvanced.service;

import com.example.springsecurityadvanced.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public Object updateEmployee(Employee employee);

    public void delete(int id);
}
