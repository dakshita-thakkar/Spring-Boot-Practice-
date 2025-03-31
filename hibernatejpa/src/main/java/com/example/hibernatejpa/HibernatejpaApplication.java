package com.example.hibernatejpa;

import com.example.hibernatejpa.dao.StudentDAO;
import com.example.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernatejpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			findStudent(studentDAO);
//			queryToRetrieveAllStudents(studentDAO);
//			queryToRetrieveAllStudentsByFirstName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);


		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		studentDAO.deleteAllStudents();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int StudentId = 3;
		studentDAO.deleteStudent(StudentId);
	}


	private void updateStudent(StudentDAO studentDAO) {
//		Find the student you want update using id
		int studentId = 1;
		Student myStudent = studentDAO.findStudentById(studentId);
		System.out.println("Student found: " + myStudent);
//		Update the student
		myStudent.setFirstName("Dakshitaaaa");
		studentDAO.updateStudent(myStudent);
		System.out.println("Student updated: " + myStudent);

	}

	private void queryToRetrieveAllStudentsByFirstName(StudentDAO studentDAO) {
		System.out.println("Finding student by first name");
		List<Student> studentList = studentDAO.findStudentByFirstName("Dakshita");
		for(Student s : studentList){
			System.out.println("Student found: " + s);
		}
	}

	private void queryToRetrieveAllStudents(StudentDAO studentDAO) {
		System.out.println("displaying all entries in students table");
		List<Student> studentList = studentDAO.findAllStudents();
		for(Student iterator: studentList){
			System.out.println("id: "+iterator.getId() + "First name: "+ iterator.getFirstName()
					+ "Last Name: "+iterator.getLastName() + "Email: " + iterator.getEmail());
		}
	}

	private void findStudent(StudentDAO studentDAO) {
		System.out.println("Finding student by id");
		Student student = studentDAO.findStudentById(1);
		System.out.println("Student found: " + student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
//		Create multiple students
		System.out.println("Creating multiple students");
		Student student1 = new Student("Renu", "Rao", "renu@gmail.com");
		Student student2 = new Student("Sushmita", "Shetty", "sushmita@gmail.com");
		Student student3 = new Student("Aditya", "Patil", "aditya@gmail.com");

//		Save the students
		System.out.println("Saving the students");
		studentDAO.saveStudent(student1);
		studentDAO.saveStudent(student2);
		studentDAO.saveStudent(student3);
// Display the ids of students saved
		System.out.println("Students saved with id: " + student1.getId() + ", "
				+ student2.getId() + ", " + student3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
//		Create the student object
		System.out.println("Creating a new student object");
		Student student = new Student("Dakshita", "Thakkar", "dak@gmail.com");
//		Save the student object
		studentDAO.saveStudent(student);
//		display the id of the saved student
		System.out.println("Student saved with id: " + student.getId());




	}

}
