package com.coderscampus.assignment;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		StudentService studentservice = new StudentService();

		studentservice.splitStudentByCourse();
		studentservice.saveStudentToFile();

		studentservice.printStudentsByCourse("course1.csv");
		studentservice.printStudentsByCourse("course2.csv");
		studentservice.printStudentsByCourse("course3.csv");
	}
}
