package com.example.hibernateJPa.jpa;

import com.example.hibernateJPa.jpa.dao.StudentDAO;
import com.example.hibernateJPa.jpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {

			// save student
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);


			// read student
			//readStudent(studentDAO);

			// read multiple students 
			queryForStudents(studentDAO);

		};
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list of student
		List<Student> students = studentDAO.findAll();

		// display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating students...");
		Student student5 = new Student("max", "limit", "max@mail.com");

		// save the student
		System.out.println("Saving students...");
		studentDAO.save(student5);

		// display the id of the student
		int id = student5.getId();

		// retrieve the student base on primary key
		System.out.println("Retrieving student with the id...: " + id);
		Student myStudent = studentDAO.findById(id);

		// display the student
		System.out.println("Student found... : " + myStudent);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating students...");
		Student student2 = new Student("Billy", "test", "billy@mail.com");
		Student student3 = new Student("axel", "max", "axel@mail.com");
		Student student4 = new Student("henry", "box", "henry@mail.com");

		// save the student object
		System.out.println("Saving students...");
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);

		// display the student id
		System.out.println("Saved students... ID: " + student2.getId());
		System.out.println("Saved students... ID: " + student3.getId());
		System.out.println("Saved students... ID: " + student4.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating student...");
		Student student1 = new Student("Larry", "Lobster", "larry@mail.com");


		// save the student object
		System.out.println("Saving student...");
		studentDAO.save(student1);

		// display the student id
		System.out.println("Saved student... ID: " + student1.getId());

	}




}
