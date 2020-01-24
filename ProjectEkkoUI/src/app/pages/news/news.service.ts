import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { Observable } from 'rxjs';

import { News } from './news.model';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  private newsApiKey = `https://newsapi.org/v2/top-headlines?country=us&apiKey=ebf4bd89e8cc4bde97eacbaf2b8662bf`;
  private url = 'https://newsapi.org/v2/'
  private apiKey = '&apiKey=ebf4bd89e8cc4bde97eacbaf2b8662bf';
  
  //Individual Query Parameters
  private worldNews = 'everything?q=worldnews';
  private usNews = 'top-headlines?country=us';
  private entertainment = 'top-headlines?country=us&category=entertainment';
  private sports = 'top-headlines?country=us&category=sports';
  private business = 'top-headlines?country=us&category=business';
  
  constructor( private httpClient:HttpClient) { }

  getNews(category: String): Observable<any>{
    console.log("Inside News Server");
    switch (category) {
      case 'worldNews':
        console.log('worldNews');
        break;
      case 'usNews':
        console.log('usNews')
        break;
        case 'entertainment':
          console.log('entertainment')
        break;
      case 'sports':
        console.log('sports')
        break;
        case 'business':
          console.log('busness')
        break;
      default:
        break;
    }

    return this.httpClient.get(this.newsApiKey);
  }

}
