package com.pti.java.point2D;

public class Point2D {

	private int x;
	private int y;
	
	public Point2D() {
		this.x=0;
		this.y=0;
	}
	public Point2D(int xy) {
		this.x = xy;
		this.y = xy;
		
	}
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	
	public int getX() { return x;}
	public int getY() {return y;}
	
	
	public boolean equals(Object object){
		
		if(object instanceof Point2D){
			
			Point2D p = (Point2D)object;
			
			if(this.getX() == p.getX() && this.getY() == p.getY()){
				return true;
			}
		}
		return false;
	}

	public String toString(){return "(" + this.x + ", " + this.y + ")";}
	
	
	}

