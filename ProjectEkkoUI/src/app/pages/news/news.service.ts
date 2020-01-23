import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { Observable } from 'rxjs';

import { News } from './news.model';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  private newsApiKey = `https://newsapi.org/v2/top-headlines?country=us&apiKey=ebf4bd89e8cc4bde97eacbaf2b8662bf`;
  // private newsApiKey = '';
  
  constructor( private httpClient:HttpClient) { }

  getNews(): Observable<any>{
    console.log("Inside News Server");
    return this.httpClient.get(this.newsApiKey);
  }

}
