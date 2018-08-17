package com.stackroute.movieservice.domain;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
	@Id
	private int movieId;
	private String movieTitle;
	private String movieRating;
	private String releaseYear;
	private String moviePoster;
	
	
//	public Movie() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	public Movie(int movieId, String movieTitle, int movieRating, int releaseYear) {
//		
//		this.movieId = movieId;
//		this.movieTitle = movieTitle;
//		this.movieRating = movieRating;
//		this.releaseYear = releaseYear;
//	}
//	
//	public int getMovieId() {
//		return movieId;
//	}
//	public void setMovieId(int movieId) {
//		this.movieId = movieId;
//	}
//	public String getMovieTitle() {
//		return movieTitle;
//	}
//	public void setMovieTitle(String movieTitle) {
//		this.movieTitle = movieTitle;
//	}
//	public float getMovieRating() {
//		return movieRating;
//	}
//	public void setMovieRating(int movieRating) {
//		this.movieRating = movieRating;
//	}
//	public int getReleaseYear() {
//		return releaseYear;
//	}
//	public void setReleaseYear(int releaseYear) {
//		this.releaseYear = releaseYear;
//	}
//

}
