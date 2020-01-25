import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class NewsService {

  private newsApiKey = `https://newsapi.org/v2/top-headlines?country=us&apiKey=ebf4bd89e8cc4bde97eacbaf2b8662bf`;
  private url = 'https://newsapi.org/v2/'
  private apiKey = '&apiKey=ebf4bd89e8cc4bde97eacbaf2b8662bf';

  // Individual Query Parameters
  private worldNews = this.url + 'everything?q=worldnews' + this.apiKey;
  private usNews = this.url + 'top-headlines?country=us' + this.apiKey;
  private entertainment = this.url + 'top-headlines?country=us&category=entertainment' + this.apiKey;
  private sports = this.url + 'top-headlines?country=us&category=sports' + this.apiKey;
  private business = this.url + 'top-headlines?country=us&category=business' + this.apiKey;

  constructor(private httpClient: HttpClient) { }

  getNews(category: String): Observable<any> {
    console.log("Inside News Server");
    switch (category) {
      case 'worldNews':
        console.log(this.worldNews);
        return this.httpClient.get(this.worldNews);

      case 'usNews':
        console.log(this.usNews);
        return this.httpClient.get(this.usNews);

      case 'entertainment':
        console.log(this.entertainment);
        return this.httpClient.get(this.entertainment);

      case 'sports':
        console.log(this.sports);
        return this.httpClient.get(this.sports);

      case 'business':
        console.log(this.business);
        return this.httpClient.get(this.business);

      default:
        return this.httpClient.get(this.newsApiKey);
    }
  }
}
