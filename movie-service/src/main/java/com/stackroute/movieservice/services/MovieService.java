package com.stackroute.movieservice.services;

import java.util.List;
//import java.util.Optional;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExists;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;



public interface MovieService {

	public Movie saveMovies(Movie movie) throws MovieAlreadyExists;

	public Movie deleteMovies(int movieId);

	public List<Movie> getAllMovies();

	public Movie getMovieById(int movieId) throws MovieNotFoundException;

	public Movie updateMovie(Movie movie);

	public List<Movie> getByTitle(String searchTerm);

	//public List<Movie> getByMovieAlpha(String searchTerm);

	
	 

	
	
	
}
