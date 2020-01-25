import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PostModule } from './core/post/post.module';
import { FooterComponent } from './shared/footer/footer.component';
import { NavBarComponent } from './shared/nav-bar/nav-bar.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { TestPageComponent } from './shared/test-page/test-page.component';
import { FoodModule } from './pages/food/food.module';
import { NewsModule } from './pages/news/news.module';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    NavBarComponent,
    FooterComponent,
    TestPageComponent
  ],
  imports: [
    HttpClientModule,
    AppRoutingModule,
    CommonModule,
    PostModule,
    FoodModule,
    NewsModule
  ],
  providers: [
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
