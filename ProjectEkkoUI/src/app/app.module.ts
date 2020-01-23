import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { NewsModule } from './news/news.module';
import { FoodModule } from './food/food.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    NavBarComponent
    
  ],
  imports: [
    BrowserModule,
    NewsModule,
    AppRoutingModule,
    FoodModule,
    HttpClientModule
  ],
  providers: [NewsModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
