package com.coderscampus.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileServices {

	// Reading student-master-list.csv which is contain all student classes data

	public Student[] ImportStudentsFromMainFile() throws IOException {
		Student[] students = new Student[100];
		BufferedReader filereader = null;
		String studentData;
		int counter = 0;
		filereader = new BufferedReader(new FileReader("student-master-list.csv"));
		studentData = filereader.readLine();
		while ((studentData = filereader.readLine()) != null) {
			students[counter] = new Student(studentData.split(",")[0], studentData.split(",")[1],
					studentData.split(",")[2], Integer.parseInt(studentData.split(",")[3]));
			counter++;
		}
		filereader.close();
		return students;

	}

}
