package com.snigdha.cruddemo;

import com.snigdha.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.snigdha.cruddemo.dao.StudentDAO;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	/*This comes from the SB Framework. The below code will be executed after the spring beans have been loaded
	i.e after starting the SB application.*/

	//We give reference of the Spring DAO and Spring will inject it accordingly.

	//Creating Bean of the StudentDAO (in background the bean of StudentDAOImpl class is created).
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		//lambda expression
		return runner-> {

			// For creating single student
			createStudent(studentDAO);
			
			//For creating multiple students
			//createMultipleStudents(studentDAO);

			//For fetching a Student
			//readStudent(studentDAO);

			//For fetching list of students
			//queryForStudents(studentDAO);

			//For fetching list of students by lastname
			//queryForStudentsByLastName(studentDAO);
			
			//For updating a student
			//updateStudent(studentDAO);

			//For deleting a student
			//deleteStudent(studentDAO);

			//For deleting all the students
			//deleteAllStudents(studentDAO);

		};
	}

	//For deleting all the students
	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+ numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id:"+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to :John"
		System.out.println("Updating student..");
		myStudent.setFirstName("Kem");

		//update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Sahu");

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create  a student object
		Student tempStudent = new Student("Snigdha","Sahu","Snigdha@luv2code.com");

		//save the student
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "  + theId);

		//retrieve student based on primary key i.e. ID
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating 3 student objects");
		Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");

		//save the student object
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	public void createStudent(StudentDAO studentDAO){

		//create the Student OBJECT
		System.out.println("Creating new student object");

		Student tempStudent = new Student("Paul","Doe","paul@love2code.com");

		//save the student object

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student generated id: "+ tempStudent.getId());
	}

}
