import { Component, OnInit } from '@angular/core';
import { NewsComponent } from '../news/news.component';
import { NewsService } from '../news.service';

@Component({
  selector: 'app-news-bar',
  templateUrl: './news-bar.component.html',
  styleUrls: ['./news-bar.component.css']
})
export class NewsBarComponent implements OnInit {
  newsCollection: any;

  constructor(private newsService : NewsService) { }

  ngOnInit() {
  }

  getNewsComponent(category: String){
    this.newsService.getNews(category)
    .subscribe
    (data => {
      this.newsCollection = data.articles;
    });
  }

}
