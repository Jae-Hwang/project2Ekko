import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { NavBarComponent } from './shared/nav-bar/nav-bar.component';
import { NewsComponent } from './pages/news/news/news.component';
import { FooterComponent } from './shared/footer/footer.component';
import { SearchComponent } from './pages/food/search/search.component';
import { ResultComponent } from './pages/food/result/result.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NewsBarComponent } from './pages/news/news-bar/news-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    NavBarComponent,
    NewsComponent,
    FooterComponent,
    SearchComponent,
    ResultComponent,
    NewsBarComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
