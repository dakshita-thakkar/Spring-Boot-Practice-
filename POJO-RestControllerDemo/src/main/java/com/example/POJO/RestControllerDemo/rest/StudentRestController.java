package com.example.POJO.RestControllerDemo.rest;


import com.example.POJO.RestControllerDemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> myStudentList = new ArrayList<>();
        Student s1 = new Student("John", "Doe");
        Student s2 = new Student("Mary", "Smith");
        myStudentList.add(s1);
        myStudentList.add(s2);
        return myStudentList;
    }

}
