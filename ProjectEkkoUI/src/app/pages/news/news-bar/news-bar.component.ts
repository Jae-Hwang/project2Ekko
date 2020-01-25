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

  constructor(private newsService : NewsService, private newsComponent: NewsComponent) { }

  ngOnInit() {
  }

  getNews(category: String){
    this.newsComponent.getNewsComponent(category);
  }
}

