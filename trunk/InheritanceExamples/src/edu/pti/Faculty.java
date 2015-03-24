package edu.pti;
/**
 * This program gives a Faculty details
 * 
 * @author Padma Dangal
 * 
 */
public class Faculty extends CollegeEmployee {

	//If college employee work 10 years
	private boolean isTenured;

	/**
	 * Parameterize constructor
	 * @param firstName new first tname of the college employee
	 * @param lastName new last name of the college employee
	 * @param streetAddress new street address of the college employee
	 * @param zipCode new zip code of the college employee
	 * @param phoneNumber new phone number of the college employee
	 * @param socialSecurityNumber new social security number of the college employee
	 * @param annualSalary new annual salary of the college employee
	 * @param departmentName new department of the college employee
	 * @param isTenured new check for tenure of the college employee
	 */
	public Faculty(String firstName, String lastName, String streetAddress,
			int zipCode, long phoneNumber, String socialSecurityNumber,
			int annualSalary, String departmentName, boolean isTenured) {
		super(firstName, lastName, streetAddress, zipCode, phoneNumber,
				socialSecurityNumber, annualSalary, departmentName);
		this.isTenured = isTenured;
	}

	/**
	 * Accessor of the tenured check
	 * @return
	 */
	public boolean isTenured() {
		return isTenured;
	}

	/**
	 * Mutator of the tenured check
	 * @return
	 */
	public void setTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}


	/**
	 * This method will gets a string representation of College Employee
	 * and concatenate with string representation of the Faculty
	 * @return A string representation of this Faculty.
	 */
	public String toString() {
		return super.toString() + " " + isTenured;
	}
	
	
	
}
