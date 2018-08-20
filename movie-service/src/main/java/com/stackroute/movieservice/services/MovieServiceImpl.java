package com.stackroute.movieservice.services;

import java.net.URI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExists;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;


@Service("movieimpl1")
public class MovieServiceImpl implements MovieService {

	MovieRepository movieRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {

		this.movieRepository = movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) throws MovieAlreadyExists {

		// TODO Auto-generated method stub
		/*
		 * 1.save in cloud 2.save to db 3.send to mail service
		 */
		if (!movieRepository.existsById(movie.getMovieId())) {
			Movie movieSaved = movieRepository.save(movie);
			return movieSaved;
		}

		else
			throw new MovieAlreadyExists("movie already exists");

	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> getAllMovies = (List<Movie>) movieRepository.findAll();
		return getAllMovies;
	}

	@Override
	public Movie getMovieById(int movieId) throws MovieNotFoundException {

		Optional<Movie> findMovie = movieRepository.findById(movieId);
		if (!findMovie.isPresent()) {
			throw new MovieNotFoundException("movie not found");

		}
		return findMovie.get();
	}

	@Override
	public Movie deleteMovies(int movieId) {

		Optional<Movie> findMovie = movieRepository.findById(movieId);
		movieRepository.deleteById(movieId);
		return findMovie.get();
	}

	@Override
	public Movie updateMovie(Movie movie) {

		Movie movieUpdated = movieRepository.save(movie);

		return movieUpdated;
	}

	// @Override
	// public List<Movie> getByMovieAlpha(String searchTerm) {
	// List<Movie> list=movieRepository.getByMovieAlpha(searchTerm);
	// return list;
	// }
	@Override
	public List<Movie> getByTitle(String movieTitle) {

		List<Movie> list = movieRepository.getByMovieTitle(movieTitle);
		return list;
	}

}
