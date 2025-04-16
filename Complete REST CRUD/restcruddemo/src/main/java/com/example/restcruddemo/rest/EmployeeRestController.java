package com.example.restcruddemo.rest;


import com.example.restcruddemo.dao.EmployeeDAO;
import com.example.restcruddemo.entity.Employee;
import com.example.restcruddemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

//    API: GET ALL EMPLOYEES
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        List<Employee> employees = employeeService.findAll();
        return employees;
    }

//    API: GET EMPLOYEE BY ID

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return employee;
    }

//    API: CREATE EMPLOYEE
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }


//    API UPDATE EMPLOYEE
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return employee;
    }

//    API: DELETE EMPLOYEE
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.delete(employeeId);
        return "Deleted employee id - " + employeeId;
    }

//    API: PATCH UPDATE -- PARTIAL UPDATES
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayLoad){
        Employee myEmployee = employeeService.findById(employeeId);

//        Throw an exception if employee not found
        if(myEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        if(patchPayLoad.containsKey("id")){
            throw new RuntimeException("You are not allowed to update the Id of an employee");
        }
        Employee updatedEmployee = apply(patchPayLoad, myEmployee);
        Employee savedEmployee = employeeService.updateEmployee(updatedEmployee);
        return savedEmployee;
    }

    private Employee apply(Map<String, Object> patchPayLoad, Employee myEmployee) {

//        Convert Employee & PatchPayLoad to JSON ObjectNode
        ObjectNode employeeNode = objectMapper.convertValue(myEmployee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayLoad, ObjectNode.class);

//        Merge the Update
        employeeNode.setAll(patchNode);
//       Convert the merged ObjectNode back to Employee
        return objectMapper.convertValue(employeeNode, Employee.class);
    }

}
