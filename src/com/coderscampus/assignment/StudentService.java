package com.coderscampus.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class StudentService {
	private Student[] students = new Student[100];
	private Student[] COMPSCIst = new Student[100];
	private Student[] STATst = new Student[100];
	private Student[] APMTHst = new Student[100];

	public StudentService() {
		FileService masterListfile = new FileService();
		try {
			students = masterListfile.importStudentsFromMainFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Arrays.sort(students);
	}

	public void splitStudentByCourse() {
		int csCntr = 0, ststCntr = 0, apmthCntr = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getCourseName().matches("COMPSCI\\s\\d\\d\\d")) {
				COMPSCIst[csCntr++] = students[i];
			} else if (students[i].getCourseName().matches("APMTH\\s\\d\\d\\d")) {
				STATst[ststCntr++] = students[i];
			} else {
				APMTHst[apmthCntr++] = students[i];
			}
		}
	}

	public void saveStudentToFile() throws IOException {
		FileService fileWriter = new FileService();

		fileWriter.writeStuentToFile(COMPSCIst, "course1.csv");
		fileWriter.writeStuentToFile(STATst, "course2.csv");
		fileWriter.writeStuentToFile(APMTHst, "course3.csv");

	}

	public void printStudentsByCourse(String fileName) throws IOException {
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
