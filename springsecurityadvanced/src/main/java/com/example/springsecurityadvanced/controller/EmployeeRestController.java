package com.example.springsecurityadvanced.controller;


import com.example.springsecurityadvanced.entity.Employee;
import com.example.springsecurityadvanced.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        List<Employee> allEmployees = employeeService.findAll();
        return allEmployees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return employee;
    }


    @PostMapping("/employees")
    public Employee createNewEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees/{employeeId}")
    public Object updateEmployee(@RequestBody Employee employee, @PathVariable int employeeId){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.delete(employeeId);
        return "Deleted employee id - " + employeeId;
    }

}
