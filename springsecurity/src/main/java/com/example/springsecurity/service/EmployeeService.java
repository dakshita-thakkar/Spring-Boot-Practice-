package com.example.springsecurity.service;

import com.example.springsecurity.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public Employee updateEmployee(Employee employee);

    public void delete(int id);
}
