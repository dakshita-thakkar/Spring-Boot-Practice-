package com.example.restdatajpacrud.dao;

import com.example.restdatajpacrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends jparepos<Employee, Integer> {
    // Custom query methods can be defined here if needed
    // For example, findByLastName(String lastName);
}
