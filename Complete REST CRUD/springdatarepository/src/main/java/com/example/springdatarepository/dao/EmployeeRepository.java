package com.example.springdatarepository.dao;

import com.example.springdatarepository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    Employee is the entity type
//    Integer is the type of the primary key
}
