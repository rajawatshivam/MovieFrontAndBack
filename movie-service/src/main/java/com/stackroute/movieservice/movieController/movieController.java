package com.stackroute.movieservice.movieController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExists;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.services.MovieService;
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/")
public class movieController {

	
	MovieService movieService;
	
	@Autowired
	public movieController(MovieService movieService) {
	this.movieService=movieService;
		
	}
	
	@RequestMapping(value = "/movie", method = RequestMethod.POST)
public ResponseEntity<?> saveMovies(@RequestBody Movie movie) throws MovieAlreadyExists {

		Movie movieobj=null;
		try {
		 movieobj=movieService.saveMovie(movie);
            }
           catch(MovieAlreadyExists m)
			{
        	   String result=m.getMessage();
        	   return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Movie>(movieobj, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMovies() {
		List<Movie> list=movieService.getAllMovies();
		
		return new ResponseEntity<List<Movie>>(list,HttpStatus.OK);

	}
	

	
	
	@RequestMapping(value = "/movie", method = RequestMethod.PUT)
	public ResponseEntity<Movie> updateMovies(@RequestBody Movie movie) {

			Movie movieobj=movieService.updateMovie(movie);
			
				return new ResponseEntity<Movie>(movieobj, HttpStatus.OK);
			}
	
	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
	public ResponseEntity<?> getMovieById(@PathVariable int movieId ) throws MovieNotFoundException{
		Movie movieobj=null;
	try {
		 movieobj=movieService.getMovieById(movieId);
		
	}
	catch(MovieNotFoundException m)
	{
		String result=m.getMessage();
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
        return new ResponseEntity<Movie>(movieobj, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/movie/delete/{movieId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMovies(@PathVariable int movieId ){
			Movie movieobj=movieService.deleteMovies(movieId);
        return new ResponseEntity<Movie>(movieobj, HttpStatus.OK);
	}

//	@RequestMapping(value = "/bychar/movie", method = RequestMethod.GET)
//	public ResponseEntity<?> getNoteByChar(@RequestParam("term") String searchTerm){
//			List<Movie> movieobj=movieService.getByMovieAlpha(searchTerm);
//        return new ResponseEntity<List<Movie>>(movieobj, HttpStatus.OK);
//	}

	@RequestMapping(value = "/movie/", method = RequestMethod.GET)
	public ResponseEntity<?> getByMovieTitle(@RequestParam String movieTitle) {
		List<Movie> list=movieService.getByTitle(movieTitle);
		
		return new ResponseEntity<List<Movie>>(list,HttpStatus.OK);

	}
	
	
	
	
}

			

	
	

