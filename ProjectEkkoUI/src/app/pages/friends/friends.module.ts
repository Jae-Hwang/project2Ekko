import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PostModule } from 'src/app/core/post/post.module';
import { FriendsPostsComponent } from './components/friends-posts/friends-posts.component';
import { FriendsComponent } from './components/friends/friends.component';
import { FriendsRoutingModule } from './friends-routing.module';

@NgModule({
  declarations: [
    FriendsComponent,
    FriendsPostsComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    RouterModule,
    FriendsRoutingModule,
    PostModule
  ]
})
export class FriendsModule { }
