package edu.pti;

/**
 * This program gives a person details
 * 
 * @author Padma Dangal
 * 
 */

public class Person {
	
	//fristname of the person
	private String firstName;
	
	//lastname of the person
	private String lastName;
	
	//streetaddress of the person
	private String streetAddress;
	
	//zipcode of the person
	private int zipCode;
	
	//phonennumber of the person
	private long phoneNumber;
	
	
	
	/**
	 * Parameterize constructor
	 * @param firstName new firstname of the person
	 * @param lastName new lastname of the person
	 * @param streetAddress new streetaddress of the person
	 * @param zipCode new zipcode of the person
	 * @param phoneNumber new phonenumber of the person
	 */
	public Person(String firstName, String lastName, String streetAddress,
			int zipCode, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}


/**
 * Accessor of the firstname
 * @return
 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * mutator of the firstname
	 * @return
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * Accessor of the lastname
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * mutator of the lastname
	 * @return
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Accessor of the streetaddress
	 * @return
	 */
	public String getStreetAddress() {
		return streetAddress;
	}


	/**
	 * mutator of the streetaddress
	 * @return
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	/**
	 * Accessor of the zipcode
	 * @return
	 */
	public int getZipCode() {
		return zipCode;
	}


	/**
	 * mutator of the zipcode
	 * @return
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	/**
	 * Accessor of the phonenumber
	 * @return
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * mutator of the phonenumber
	 * @return
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Compares the given object to this person
	 * 
	 * @return True if the object is firstname, lastname, streetAddress, zipcode and phonenumber is equal Otherwise, returns false
	 */
	public boolean equal(Object object){
		
		if (object instanceof Person) {
			
			Person person = (Person) object;

			return person.getFirstName() == this.firstName && person.getLastName() == this.lastName && person.getStreetAddress() == this.getStreetAddress() && person.getZipCode() == this.getZipCode() && person.getPhoneNumber() == this.getPhoneNumber();
		}
		// Not even a person, so don't compare
		return false;
	}

	/**
	 * This method will gets a string representation of this person.
	 * 
	 * @return A string representation of this person.
	 */
	public String toString() {
		return  firstName + " " + lastName
				+ " " + streetAddress + " " + zipCode
				+ " " + phoneNumber;
	}
	
	
	

	
}
