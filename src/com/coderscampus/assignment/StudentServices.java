package com.coderscampus.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class StudentServices {
	private Student[] students = new Student[100];

	public StudentServices() {
		FileServices masterListfile = new FileServices();
		try {
			students = masterListfile.ImportStudentsFromMainFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Arrays.sort(students);
	}

	public void splitStudentsByCourse() throws FileNotFoundException, IOException {
		BufferedWriter course1 = new BufferedWriter(new FileWriter("course1.csv"));
		BufferedWriter course2 = new BufferedWriter(new FileWriter("course2.csv"));
		BufferedWriter course3 = new BufferedWriter(new FileWriter("course3.csv"));
		course1.write("Student ID,Student Name,Course,Grade\n");
		course2.write("Student ID,Student Name,Course,Grade\n");
		course3.write("Student ID,Student Name,Course,Grade\n");
		for (int i = 0; i < students.length; i++) {
			if (students[i].getCourseName().matches("COMPSCI\\s\\d\\d\\d")) {
				String str = String.join(",", students[i].getStudentId(), students[i].getStudentName(),
						students[i].getCourseName(), Integer.toString(students[i].getGrade()));
				course1.write(str);
				course1.write("\n");
			} else if (students[i].getCourseName().matches("APMTH\\s\\d\\d\\d")) {
				String str = String.join(",", students[i].getStudentId(), students[i].getStudentName(),
						students[i].getCourseName(), Integer.toString(students[i].getGrade()));
				course2.write(str);
				course2.write("\n");
			} else {
				String str = String.join(",", students[i].getStudentId(), students[i].getStudentName(),
						students[i].getCourseName(), Integer.toString(students[i].getGrade()));
				course3.write(str);
				course3.write("\n");
			}
		}
		course1.close();
		course2.close();
		course3.close();
	}

	public void printStudentsByCourses(String fileName) throws IOException {
		System.out.println(fileName + "\n");
		BufferedReader filereader = null;
		String studentData;
		filereader = new BufferedReader(new FileReader(fileName));
		while ((studentData = filereader.readLine()) != null) {
			System.out.println(studentData);
		}
		filereader.close();
	}

}
