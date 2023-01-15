package com.coderscampus.assignment;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		StudentServices studentservices = new StudentServices();

		studentservices.splitStudentsByCourse();

		studentservices.printStudentsByCourses("course1.csv");
		studentservices.printStudentsByCourses("course2.csv");
		studentservices.printStudentsByCourses("course3.csv");
	}
}
