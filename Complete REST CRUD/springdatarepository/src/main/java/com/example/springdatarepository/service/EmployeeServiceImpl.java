package com.example.springdatarepository.service;

import com.example.springdatarepository.dao.EmployeeRepository;
import com.example.springdatarepository.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Method to list all employees
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //    Method to find employee by id
    @Override
    public Employee findById(int id) {
//        Check if Employee exists using Optionals
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }
    //    Method to update employee
//    @Override
//    @Transactional
//    public Employee updateEmployee(Employee employee) {
//        Employee emp = .updateEmployee(employee);
//        return emp;
//    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
