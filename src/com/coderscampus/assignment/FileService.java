package com.coderscampus.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

// Reading student-master-list.csv which is contain all student classes data
	public Student[] importStudentsFromMainFile() throws IOException {
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

// write different student to different CSV file and divided by course name
	public void writeStuentToFile(Student[] students, String filename) throws IOException {
		BufferedWriter courseWriter;
		courseWriter = new BufferedWriter(new FileWriter(filename));
		courseWriter.write("Student ID,Student Name,Course,Grade\n");
		for (Student student : students) {
			if (student != null) {
				String str = String.join(",", student.getStudentId(), student.getStudentName(), student.getCourseName(),
						Integer.toString(student.getGrade()));
				courseWriter.write(str);
				courseWriter.write("\n");
			}
		}
		courseWriter.close();
	}
}
