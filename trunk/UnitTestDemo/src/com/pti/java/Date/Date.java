package com.pti.java.Date;

import com.pti.java.point2D.Point2D;
/**
 * This class allow the user to set the date and compare the Entered date with the default date.
 * @author Padma Dangal.
 *
 */
public class Date {
	
	/*
	 * Private variables for the date.
	 */
	private int month;
	private int day;
	private int year;
	private int hour;
	private int minute;
	private int second;
	
	/*
	 * Non-parameterize constructor.
	 * variables of constructor are assign to give value.
	 */
	public Date(){
		this.month = 5;
		this.day = 10;
		this.year = 1951;
		this.hour = 10;
		this.minute = 5;
		this.second = 0;
	}
	
	/*
	 * Parameterize constructor.
	 * month, day and year are the parameter of the constructor.
	 */
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		
	}
	
	/*
	 * Parameterize constructor.
	 * month, day, year, hour, minute and second are the parameter of the constructor.
	 */
		public Date(int month, int day, int year, int hour, int minute, int second) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	/*
	 * Mutator to set a new month.
	 */
	public void setMonth(int month) {this.month = month;}
	
	/*
	 * Mutator to set a new day.
	 */
	public void setDay(int day) {this.day = day;}
	
	/*
	 * Mutator to set a new year.
	 */
	public void setYear(int year) {this.year = year;}
	
	/*
	 * Mutator to set a new hour.
	 */
	public void setHour(int hour) {this.hour = hour;}
	
	/*
	 * Mutator to set a new minute.
	 */
	public void setMinute(int minute) {this.minute = minute;}
	
	/*
	 * Mutator to set a new second.
	 */
	public void setSecond(int second) {this.second = second;}
	
	
	
	/*
	 * Accessor to get a month. 
	 */
	public int getMonth() {return month;}

	/*
	 * Accessor to get a day. 
	 */
	public int getDay() {return day;}

	/*
	 * Accessor to get a year. 
	 */
	public int getYear() {return year;}

	/*
	 * Accessor to get a hour. 
	 */
	public int getHour() {return hour;}
	
	/*
	 * Accessor to get a minute. 
	 */
	public int getMinute() {return minute;}

	/*
	 * Accessor to get a second. 
	 */
	public int getSecond() {return second;}
	
	
	
	/*
	 * This method will compare the given date with the default date.
	 * If the given date is greater than default date, it return 1.
	 * If the given date is smaller than default date, it return -1.
	 * If the given date is equal to default date, it return 0.
	 */
	public int compare(Date date){
		
		Date d1 = new Date(month, day, year);
		
		
		if(d1.getYear() > date.getYear()){         
			
			return 1;
			
		}else if(d1.getYear() < date.getYear()){
		
			return -1;
		}
		
		else if(d1.getYear() == date.getYear()){
			
			if(d1.getMonth() > date.getMonth()){
				
				return 1;
			}else if(d1.getMonth() < date.getMonth()){
				return -1;
			}
			
			else if(d1.getMonth() == date.getMonth()){
				
				if(d1.getDay() > date.getDay()){
					
					return 1;
				}else if(d1.getDay() < date.getDay()){
					
					return -1;
				}else if(d1.getDay() == date.getDay()){
					
					return 0;
				}
				
				return 0;
			}
			return 0;
		}
		return 0;
		
	}

	/*
	 * toString method will print the date.
	 * It includes month, day , year, hour minute and second.
	 */
	public String toString() {
		return "( month=" + month + ", day=" + day + ", year=" + year
				+ ", hour=" + hour + ", minute=" + minute + ", second="
				+ second + " )";
	}
	

}
