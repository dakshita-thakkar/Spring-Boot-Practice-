package com.example.exceptionHandling.rest;


import com.example.exceptionHandling.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private List<Student> myStudents;

    @PostConstruct

    public List<Student> loadData(){
        myStudents = new ArrayList<>();
        Student s1 = new Student("John", "Doe");
        Student s2 = new Student("Mary", "Public");
        myStudents.add(s1);
        myStudents.add(s2);
        return myStudents;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return myStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
//        return myStudents.get(studentId);
        if(studentId >= myStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }else{
            return myStudents.get(studentId);
        }
    }

//    Add a custom Exception Handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//        Create a new StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
//        Set the values
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
//        Return the response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllException(Exception exc){
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("You entered a wrong value");
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
