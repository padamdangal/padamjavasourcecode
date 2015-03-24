/**
 * 
 */
package com.pti.java.Date;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pti.java.point2D.Point2D;

/**
 * This is the test case of the class Date which will test all the methods of Date class.
 * @author Padma Dangal.
 *
 */
public class DateTest {

	
	/**
	 * Test method for non-parameterize constructor.
	 */
	@Test
	public void testDate() {
		
    Date date = new Date();
		
	assertNotNull("Parameterless Date constructor fails", date);
	
	}

	/**
	 * Test method for three parameterize constructor.
	 */
	@Test
	public void testDateIntIntInt(){
		
		Date date = new Date(3, 27, 2014);
		assertNotNull("Three parameter Date constructor fails", date);
		assertEquals(3, date.getMonth());
		assertEquals(27, date.getDay());
		assertEquals(2014, date.getYear());
	}
	
	/**
	 * Test method for six parameterize constructor.
	 */
	@Test
	public void testDateIntIntIntIntIntInt(){
		
		Date date = new Date(8, 20, 2010, 5, 35, 51);
		assertNotNull("Six parameter Date constructor fails", date);
		assertEquals(8, date.getMonth());
		assertEquals(20, date.getDay());
		assertEquals(2010, date.getYear());
		assertEquals(5, date.getHour());
		assertEquals(35, date.getMinute());
		assertEquals(51, date.getSecond());
	}
	
	/**
	 * Test method for Set month.
	 */
	@Test
	public void testSetMonth() {
		Date date = new Date();
		date.setMonth(2);
	    assertEquals(2, date.getMonth());
		
	}
	
	/**
	 * Test method for Set Day.
	 */
	@Test
	public void testSetDay() {
		Date date = new Date();
		date.setDay(23);
		assertEquals(23, date.getDay());
		
	}
	/**
	 * Test method for Set Year.
	 */
	@Test
	public void testSetYear() {
		Date date = new Date();
		date.setYear(2015);
		assertEquals(2015, date.getYear());
		
	}
	/**
	 * Test method for Set Hour.
	 */
	@Test
	public void testSetHour() {
		Date date = new Date();
		date.setHour(9);
		assertEquals(9, date.getHour());
		
	}
	/**
	 * Test method for Set Minute.
	 */
	@Test
	public void testSetMinute() {
		Date date = new Date();
		date.setMinute(52);
		assertEquals(52, date.getMinute());
		
	}
	/**
	 * Test method for Set Second.
	 */
	@Test
	public void testSetSecond() {
		Date date = new Date();
		date.setSecond(18);
		assertEquals(18, date.getSecond());
		
	}
	
	/**
	 * Test method for Get Month.
	 */
	@Test
	public void testGetMonth() {
		
		Date date = new Date();
		assertEquals("Get Month() Method failed. " + date.getMonth() + " !=5", 5,  date.getMonth());
	}
	
	/**
	 * Test method for Get Day.
	 */
	@Test
	public void testGetDay() {
		
		Date date = new Date();
		assertEquals("Get day() Method failed. " + date.getDay() + " !=10", 10,  date.getDay());
	}
	/**
	 * Test method for Get Year.
	 */
	@Test
	public void testGetYear() {
		
		Date date = new Date();
		assertEquals("Get Year() Method failed. " + date.getYear() + " !=1951", 1951,  date.getYear());
	}
	/**
	 * Test method for Get Hour.
	 */
	@Test
	public void testGetHour() {
		
		Date date = new Date();
		assertEquals("Get Hour() Method failed. " + date.getHour() + " !=10", 10,  date.getHour());
	}
	/**
	 * Test method for Get Minute.
	 */
	@Test
	public void testGetMinute() {
		
		Date date = new Date();
		assertEquals("Get Minute() Method failed. " + date.getMinute() + " !=5", 5,  date.getMinute());
	}
	/**
	 * Test method for Get Second.
	 */
	@Test
	public void testGetSecond() {
		
		Date date = new Date();
		assertEquals("Get Second() Method failed. " + date.getSecond() + " !=0", 0,  date.getSecond());
	}
	
	/**
	 * Test method for Compare.
	 */
	@Test
	public void testCompare(){
		Date d1 = new Date();
		Date d2 = new Date();
		
	    assertEquals(0, d1.compare(d2));
	    
	 // If the given date is greater than default date, it return 1.
	    d1.setYear(2014);
	    assertEquals(1, d1.compare(d2));   
	    
	    d1.setMonth(7);
		assertEquals(1, d1.compare(d2)); 
		  
		d1.setDay(12);
		assertEquals(1, d1.compare(d2));                       
	    				                        
	  //If the given date is smaller than default date, it return -1.
		d1.setYear(1949);
	    assertEquals(-1, d1.compare(d2));
		 
	    d1.setMonth(3);
		assertEquals(-1, d1.compare(d2)); 
			  
	    d1.setDay(8);
		assertEquals(-1, d1.compare(d2)); 
		  
		//If the given date is equal to default date, it return 0;
		d1.setYear(1951);
		d1.setMonth(5);
		d1.setDay(10);
		assertEquals(0, d1.compare(d2));
	}
	

	/**
	 * Test method for toString.
	 */
	@Test
	public void testToString() {
		
		Date date = new Date();
		
		assertTrue("toString() method failed", date.toString().equals("( month=5, day=10, year=1951, hour=10, minute=5, second=0 )"));
	}
}
