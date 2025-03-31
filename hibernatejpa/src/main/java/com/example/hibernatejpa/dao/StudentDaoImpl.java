package com.example.hibernatejpa.dao;

import com.example.hibernatejpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void saveStudent(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    @Transactional
    public Student findStudentById(int studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> findAllStudents() {
        //Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        // Return result;
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findStudentByFirstName(String firstName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student s WHERE s.firstName = :firstName", Student.class);
        theQuery.setParameter("firstName", firstName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(int id){
        Student myStudent = entityManager.find(Student.class, id);
        entityManager.remove(myStudent);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        int numrowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numrowsDeleted;
    }


}
