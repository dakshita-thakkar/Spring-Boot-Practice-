package com.example.restcrudpractice.dao;

import com.example.restcrudpractice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
