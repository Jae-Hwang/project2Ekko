import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private APPID = '&app_id='+'757e0f3f'
  private APIKEY = '&app_key='+'12f04ba0f91861aefd92599ce31a1611'
  private URL = 'https://api.edamam.com/search?q='
  // private queryParam = 'chicken'

  // private full = this.URL+this.queryParam+this.APPID+this.APIKEY

  constructor(private httpClient : HttpClient) { }

  getFoodResults(foodQuery): Observable<any>{
    console.log("Inside Food Search");
    return this.httpClient.get(this.URL + foodQuery + this.APPID + this.APIKEY);
  }



}