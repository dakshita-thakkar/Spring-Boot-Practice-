package com.example.springsecurityadvanced.service;

import com.example.springsecurityadvanced.dao.EmployeeRepository;
import com.example.springsecurityadvanced.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //    To get a list of all employees
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //    To find employee by id

    @Override
    public Employee findById(int id) {
        return (Employee) employeeRepository.findById(id).orElse(null);
    }
    // To create a new employee
    @Override
    @Transactional
    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    @Transactional
    public Object updateEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if(optionalEmployee.isPresent()){
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());
            return employeeRepository.save(existingEmployee);
        }
        else{
            throw new RuntimeException("Employee not found with id: " + employee.getId());
        }
    }


    @Override
    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
