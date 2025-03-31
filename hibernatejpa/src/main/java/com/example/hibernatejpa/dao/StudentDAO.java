package com.example.hibernatejpa.dao;

import com.example.hibernatejpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void saveStudent(Student theStudent);

    Student findStudentById(int studentId);

    List<Student> findAllStudents();

    List<Student> findStudentByFirstName(String firstName);

    void updateStudent(Student theStudent);

    void deleteStudent(int studentId);
    int deleteAllStudents();
}
