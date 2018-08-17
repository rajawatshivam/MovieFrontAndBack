import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from './movie';

@Injectable()
export class MovieService {

  private movie_url = 'https://api.themoviedb.org/3/';
  private api_key = '19ab98ad55324f2be9a19b5ca671c97b';
  private movie_string: string;
  private id: number;

  constructor(public http: HttpClient) { }
  private post_url = 'http://localhost:8080/api/v1/movie';
  private get_url = 'http://localhost:8080/api/v1/movies';
  private delete_url = 'http://localhost:8080/api/v1/movie/delete';
  searchMovie(movie: string) {
    this.movie_string = movie;
    return this.http.get(this.movie_url + 'search/movie?query=' + this.movie_string + '&api_key=' + this.api_key);
  }

  getUpcomingMovies() {
    // tslint:disable-next-line:max-line-length
    return this.http.get(this.movie_url + 'discover/movie?primary_release_date.gte=2018-04-15&primary_release_date.lte=2018-07-31' + '&api_key=' + this.api_key);
  }

  getPopularMovies() {
    return this.http.get(this.movie_url + 'discover/movie?sort_by=popularity.desc' + '&api_key=' + this.api_key);
  }

  getMovie(id: number) {
    return this.http.get(this.movie_url + 'movie/' + id + '?api_key=' + this.api_key);
  }

  getWishList(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.get_url);
  }

  
  addMovie(movie:Movie):Observable<Movie>{
    return this.http.post<Movie>(this.post_url,movie);
  }
  deleteWishList(id){
    return this.http.delete(this.delete_url + '/' +id)
    }

  }
// Get popular movies api
// https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=API_KEY
// Get upcoming movies api
// tslint:disable-next-line:max-line-length
// https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2018-04-15&primary_release_date.lte=2018-07-31&api_key=API_KEY
// Search movies api
// https://api.themoviedb.org/3/search/movie?query=SEARCH_STRING&api_key=API_KEY
// Get movie from api
// https://api.themoviedb.org/3/movie/ID?api_key=API_KEY
