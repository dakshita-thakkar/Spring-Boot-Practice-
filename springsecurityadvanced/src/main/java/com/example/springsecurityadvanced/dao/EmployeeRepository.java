package com.example.springsecurityadvanced.dao;

import com.example.springsecurityadvanced.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
