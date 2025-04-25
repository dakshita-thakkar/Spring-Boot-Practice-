package com.example.bcryptsecurity.controller;


import com.example.bcryptsecurity.entity.Employee;
import com.example.bcryptsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


//    GET ALL EMPLOYEES
    @GetMapping("/myemployee")
    public List<Employee> getAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/myemployee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){

        Employee myEmployee = employeeService.getEmployeeById(employeeId);
        if(myEmployee==null){
            throw new RuntimeException("Employee not found of id:" +employeeId);
        }
        return myEmployee;
    }


    @PostMapping("/myemployee")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
       employeeService.addEmployee(employee);
       return employee;

    }

    @PutMapping("/myemployee/{employeeId}")
    public Object updateEmployee(@RequestBody Employee employee, @PathVariable int employeeId){
        return employeeService.updateEmployee(employee);
    }
}
