/**
 * 
 */
package com.pti.java.point2D;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Padma Dangal
 *
 */
public class Point2DTest {

	/**
	 * Test method for non-parameterize constructor.
	 */
	@Test
	public void testPoint2D() {
		
		Point2D point1 = new Point2D();
		
		assertNotNull("Parameterless Point2D constructor fails", point1);
		
	}

	/**
	 * Test method for one parameterize constructor.
	 */
	@Test
	public void testPoint2DInt() {
		
		Point2D point1 = new Point2D(5);
		assertNotNull("Single parameter Point2D constructor fails", point1);
		assertEquals(5, point1.getX());
		assertEquals(5, point1.getY());

	}

	/**
	 * Test method for two parameterize constructor.
	 */
	@Test
	public void testPoint2DIntInt() {
		Point2D point1 = new Point2D(5, 8);
		assertNotNull("Single parameter Point2D constructor fails", point1);
		assertEquals(5, point1.getX());
		assertEquals(8, point1.getY());
	}

	/**
	 * Test method for Set X.
	 */
	@Test
	public void testSetX() {
		Point2D point1 = new Point2D();
		point1.setX(5);
	    assertEquals(5, point1.getX());
		
	}

	/**
	 * Test method for set Y.
	 */
	@Test
	public void testSetY() {
		Point2D point1 = new Point2D();
		point1.setY(5);
	    assertEquals(5, point1.getY());
	}

	/**
	 * Test method Get x.
	 */
	@Test
	public void testGetX() {
		
		Point2D point1 = new Point2D();
		assertEquals("Get X() Method failed. " + point1.getX() + " !=0", 0,  point1.getX());
		
	}

	/**
	 * Test method Get Y.
	 */
	@Test
	public void testGetY() {
		Point2D point1 = new Point2D();
		assertEquals("Get X() Method failed. " + point1.getX() + " !=0", 0,  point1.getX());
	}

	/**
	 * Test method equals.
	 */
	@Test
	public void testEqualsObject() {
		Point2D point1 = new Point2D();
		Point2D point2 = new Point2D();
		assertTrue("Method equal() Fail if X and Y of points are not equal",point1.getX()==point2.getX() && point1.getY() == point2.getY());
      
	}

	/**
	 * Test method toString.
	 */
	@Test
	public void testToString() {
		
		Point2D point1 = new Point2D();
		
		assertTrue("toString() method failed", point1.toString().equals("(0, 0)"));
	}

}
