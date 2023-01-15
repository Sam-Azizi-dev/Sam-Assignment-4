package com.coderscampus.assignment;

public class Student implements Comparable<Student> {
	private String studentId;
	private String studentName;
	private String courseName;
	private Integer grade;

	public Student(String studentId, String studentName, String courseName, Integer grade) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseName = courseName;
		this.grade = grade;
	}

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", courseName=" + courseName
				+ ", grade=" + grade + "]";
	}

	@Override
	public int compareTo(Student otherStudent) {
		if ((this.grade > otherStudent.grade) || (otherStudent.getGrade() == null)) {
			return -1;
		} else if (this.grade < otherStudent.grade) {
			return 1;
		} else {
			return 0;
		}
	}

}
