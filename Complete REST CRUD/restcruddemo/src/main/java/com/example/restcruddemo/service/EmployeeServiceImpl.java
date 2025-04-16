package com.example.restcruddemo.service;

import com.example.restcruddemo.dao.EmployeeDAO;
import com.example.restcruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

// Method to list all employees
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

//    Method to find employee by id
    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }
//    Method to update employee
    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        Employee emp = employeeDAO.updateEmployee(employee);
        return emp;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        employeeDAO.save(employee);
        return employee;
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.delete(id);
    }


}
