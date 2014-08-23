package com.java.springwithmaven.SpringPrj;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements IMovieService {

	@Autowired
	@Qualifier("moviedao")
	private MovieDAOImpl dao;
	
	public List<Movie> getBluRayMovies() {

		List<Movie> allmovies = dao.getMovies();
		
		List<Movie> bluraymovies = new ArrayList<Movie>();
		
		for(Movie movie:allmovies){
			if(movie.getType().equalsIgnoreCase("Bluray")){
				bluraymovies.add(movie);
			}
		}
		return bluraymovies;
	}

}
