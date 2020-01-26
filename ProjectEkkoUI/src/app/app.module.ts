import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PostModule } from './core/post/post.module';
import { FoodModule } from './pages/food/food.module';
import { NewsModule } from './pages/news/news.module';
import { FooterComponent } from './shared/footer/footer.component';
<<<<<<< HEAD
import { SearchComponent } from './pages/food/search/search.component';
import { ResultComponent } from './pages/food/result/result.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NewsBarComponent } from './pages/news/news-bar/news-bar.component';
import { LoginComponent } from './pages/login/components/login/login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { DirMessageComponent } from './core/components/dir-message/dir-message.component';
import { GroupChatComponent } from './core/components/group-chat/group-chat.component';
=======
import { NavBarComponent } from './shared/nav-bar/nav-bar.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { TestPageComponent } from './shared/test-page/test-page.component';


>>>>>>> IntegratingUserIntoPosts

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    NavBarComponent,
    FooterComponent,
<<<<<<< HEAD
    SearchComponent,
    ResultComponent,
    NewsBarComponent,
    DirMessageComponent,
    GroupChatComponent,
=======
    TestPageComponent
>>>>>>> IntegratingUserIntoPosts
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    RouterModule,
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
