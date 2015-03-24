package edu.pti;

/**
 * This program gives a Student details
 * 
 * @author Padma Dangal
 * 
 */

public class Student extends Person {

	//major of the student
	private String studentMajor;
	
	//grade point average of the student
	private double gradePointAverage;
	
	/**
	 * Parameterize constructor
	 * @param firstName new first name of the student
	 * @param lastName new last name of the student
	 * @param streetAddress new street address of the student
	 * @param zipCode new zip code of the student
	 * @param phoneNumber new phone number of the student
	 * @param studentMajor new major of the student
	 * @param gradePointAverage new grade point average of the student
	 */
	public Student(String firstName, String lastName, String streetAddress,
			int zipCode, long phoneNumber, String studentMajor,
			double gradePointAverage) {
		super(firstName, lastName, streetAddress, zipCode, phoneNumber);
		this.studentMajor = studentMajor;
		this.gradePointAverage = gradePointAverage;
	}

	/**
	 * Accessor of the student major
	 * @return
	 */
	public String getStudentMajor() {
		return studentMajor;
	}

	/**
	 * Mutator of the student major
	 * @return
	 */
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}

	/**
	 * Accessor of the grade point average
	 * @return
	 */
	public double getGradePointAverage() {
		return gradePointAverage;
	}

	/**
	 * Mutator of the grade point average
	 * @return
	 */
	public void setGradePointAverage(double gradePointAverage) {
		this.gradePointAverage = gradePointAverage;
	}


	/**
	 * This method will gets a string representation of Person
	 * and concatenate with string representation of the Student
	 * @return A string representation of this Student.
	 */
	public String toString() {
		return super.toString() + " " + studentMajor + " "
				+ gradePointAverage;
	}
	
	
}
