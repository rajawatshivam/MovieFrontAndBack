package com.stackroute.movieservice.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	MovieRepository movieRepository;
	
	@Autowired
	 public CommandLineAppStartupRunner(MovieRepository movieRepository) {
		
		this.movieRepository = movieRepository;
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		
//		logger.info("Application started with command-line arguments: {} . "
//		 		+ "\n To kill this application, press Ctrl + C.", Arrays.toString(args));
		
		Movie movie=new Movie();
		movie.setMovieId(5);
		
		movie.setMovieTitle("krish");
		 movieRepository.save(movie);

		
	}

}
