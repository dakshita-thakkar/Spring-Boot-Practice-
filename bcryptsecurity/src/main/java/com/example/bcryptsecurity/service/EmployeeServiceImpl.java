package com.example.bcryptsecurity.service;

import com.example.bcryptsecurity.dao.EmployeeRepository;
import com.example.bcryptsecurity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();

    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {

        employeeRepository.save(employee);
        return employee;

    }

    @Override
    @Transactional
    public Object updateEmployee(Employee employee) {
        Optional<Employee> myEmployee = employeeRepository.findById(employee.getId());
        if(myEmployee.isPresent()){
            Employee existingEmployee = myEmployee.get();
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());
            return Optional.of(employeeRepository.save(existingEmployee));
        }
        else{
            throw new RuntimeException("Employee not found with id"+ employee.getId());
        }
    }


}
