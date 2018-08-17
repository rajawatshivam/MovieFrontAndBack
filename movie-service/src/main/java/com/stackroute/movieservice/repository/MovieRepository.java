package com.stackroute.movieservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.stackroute.movieservice.domain.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {


	public List<Movie> getByMovieTitle(String MovieTitle);
	
//	@Query("SELECT movie FROM Movie movie WHERE movie.movieTitle LIKE CONCAT(:searchTerm,'%')")
//public List<Movie> getByMovieAlpha(String searchTerm);


	
}
