package com.java.springwithmaven.SpringPrj;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("moviedao")
public class MovieDAOImpl implements ImovieDAO {

	public List<Movie> getMovies() {

		Movie movie = new Movie();
		movie.setTitle("Capitan America");
		movie.setType("Bluray");
		movie.setRentalPrice(2.0);
		
		Movie movie1 = new Movie();
		movie1.setTitle("Kick");
		movie1.setType("Bluray");
		movie1.setRentalPrice(5.0);

		List<Movie> movies = new ArrayList<Movie>();
		movies.add(movie);
		movies.add(movie1);

		return movies;
	}

}
