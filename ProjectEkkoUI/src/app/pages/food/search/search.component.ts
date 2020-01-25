import { Component, OnInit } from '@angular/core';
import { SearchService } from './search.service'


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  results: any[];

  constructor(private searchService: SearchService) { }

  ngOnInit() {
    // this.getResults();
  }

  getResults(foodQuery){
    this.searchService.getFoodResults(foodQuery)
    .subscribe
    (data => {
      this.results = data.hits;
      // console.log(data.hits[0].recipe)
    });
  }

}
