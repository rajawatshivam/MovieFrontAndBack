import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {
  movie: any;
  movieList= [];
  deleteList: any;
  constructor(private router: ActivatedRoute, private movieService: MovieService) { }
  ngOnInit() {
    this.movieService.getWishList().subscribe(fullList => this.movieList = fullList);
    console.log(this.movieList);
    }
    onWorking(id) {
      this.movieService.deleteWishList(id).subscribe(data => this.deleteList = data);
      }
 }
