package com.java.spring;

public class Triangle implements Shape {

	@Override
	public void draw() {
		System.out
				.println("Triangle is drawn. Jst checking with application context instead BeanFactory");

	}
}
