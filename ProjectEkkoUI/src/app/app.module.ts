import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { NavBarComponent } from './shared/nav-bar/nav-bar.component';
import { NewsComponent } from './pages/news/news/news.component';
import { FooterComponent } from './shared/footer/footer.component';
import { SearchComponent } from './pages/food/search/search.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NewsBarComponent } from './pages/news/news-bar/news-bar.component';
import { SearchService } from './pages/food/search/search.service';
import { NewsService } from './pages/news/news.service';
import { NewsModule } from './pages/news/news.module';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    NavBarComponent,
    NewsComponent,
    FooterComponent,
    SearchComponent,
    NewsBarComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
