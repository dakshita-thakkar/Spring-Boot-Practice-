package com.example.globalExceptionHandling.rest;


import com.example.globalExceptionHandling.entity.StudentResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
//    Add Exception handling code

    @ExceptionHandler
    public ResponseEntity<StudentResponseError> handleException(StudentNotFoundException exc){
        // Create a new StudentErrorResponse
        StudentResponseError error = new StudentResponseError();
        // Set the values
        error.setStatus("404");
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        // Return the response entity
        return new ResponseEntity<>(error, org.springframework.http.HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentResponseError> handleException(Exception exc){
        // Create a new StudentErrorResponse
        StudentResponseError error = new StudentResponseError();
        // Set the values
        error.setStatus("500");
        error.setMessage("Something went wrong " + exc.getMessage() );
        error.setTimeStamp(System.currentTimeMillis());
        // Return the response entity
        return new ResponseEntity<>(error, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
