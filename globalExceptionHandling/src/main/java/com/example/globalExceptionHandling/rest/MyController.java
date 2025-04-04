package com.example.globalExceptionHandling.rest;


import com.example.globalExceptionHandling.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    List<Student> myStudents;

    @PostConstruct
    public void loadData(){
        myStudents = new ArrayList<>();
        Student s1 = new Student("John", "Doe");
        Student s2 = new Student("Mary", "Public");
        myStudents.add(s1);
        myStudents.add(s2);
    }

    @GetMapping("/students/{studentId}")
    public Student getMyStudents(@PathVariable int studentId) {
        if (studentId >= myStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        } else {
            return myStudents.get(studentId);
        }
    }
}
