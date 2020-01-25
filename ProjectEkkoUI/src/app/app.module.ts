import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PostComponent } from './core/post/components/post/post.component';
import { ResultComponent } from './pages/food/result/result.component';
import { SearchComponent } from './pages/food/search/search.component';
import { NewsBarComponent } from './pages/news/news-bar/news-bar.component';
import { NewsComponent } from './pages/news/news/news.component';
import { FooterComponent } from './shared/footer/footer.component';
import { NavBarComponent } from './shared/nav-bar/nav-bar.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { TestPageComponent } from './shared/test-page/test-page.component';
import { PostModule } from './core/post/post.module';


@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    NavBarComponent,
    NewsComponent,
    FooterComponent,
    SearchComponent,
    ResultComponent,
    NewsBarComponent,
    TestPageComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    PostModule
  ],
  providers: [

  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
