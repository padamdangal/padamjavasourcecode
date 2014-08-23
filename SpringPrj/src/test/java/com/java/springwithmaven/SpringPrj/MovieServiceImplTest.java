package com.java.springwithmaven.SpringPrj;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieServiceImplTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");

		IMovieService service = context.getBean(IMovieService.class);

		List<Movie> movies = service.getBluRayMovies();
		
		for (Movie movie : movies) {
			System.out.println("Title = " + movie.getTitle());
		}
	}

}
