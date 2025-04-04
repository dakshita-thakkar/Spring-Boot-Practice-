package com.example.pathVariable.rest;

import com.example.pathVariable.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    List<Student> myStudentsList;

    @PostConstruct
    public void loadData(){
        myStudentsList = new ArrayList<>();
        myStudentsList.add(new Student("John", "Doe"));
        myStudentsList.add(new Student("Mary", "Smith"));
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return myStudentsList.get(studentId);
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return myStudentsList;
    }


}
