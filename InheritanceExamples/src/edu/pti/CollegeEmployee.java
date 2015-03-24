package edu.pti;

/**
 * This program gives a College Employee details
 * 
 * @author Padma Dangal
 * 
 */

public class CollegeEmployee extends Person {
	
//social security number of the college employee
	private String socialSecurityNumber;
	
	//annual salary of the college employee
	private int annualSalary;
	
	//department name of the college employee
	private String departmentName;
	
	/**
	 * Parameterize constructor
	 * @param firstName new firs tname of college employee
	 * @param lastName new last name of college employee
	 * @param streetAddress new street address of college employee
	 * @param zipCode new zip code of college employee
	 * @param phoneNumber new phone number of college employee
	 * @param socialSecurityNumber new social security number of college employee
	 * @param annualSalary new anual salary of college employee
	 * @param departmentName new department name of college employee
	 */
	public CollegeEmployee(String firstName, String lastName,
			String streetAddress, int zipCode, long phoneNumber,
			String socialSecurityNumber, int annualSalary, String departmentName) {
		
		//invoked from the parent class Person
		super(firstName, lastName, streetAddress, zipCode, phoneNumber);
		this.socialSecurityNumber = socialSecurityNumber;
		this.annualSalary = annualSalary;
		this.departmentName = departmentName;
	}

	/**
	 * Accessor of the social security number
	 * @return
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * mutator of the social security number
	 * @return
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	/**
	 * Accessor of the annual salary
	 * @return
	 */
	public int getAnnualSalary() {
		return annualSalary;
	}

	/**
	 * mutator of the annual salary
	 * @return
	 */
	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}

	/**
	 * Accessor of the department name
	 * @return
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * mutaotr of the department name
	 * @return
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	/**
	 * This method will gets a string representation of Person
	 * and concatenate with string representation of the CollegeEmployee
	 * @return A string representation of this CollegeEmployee.
	 */
	public String toString() {
		return  super.toString() + " " + socialSecurityNumber
				+ " " + annualSalary + " "
				+ departmentName;
	}
}
