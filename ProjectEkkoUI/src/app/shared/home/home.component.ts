import { Component, OnInit, OnDestroy } from '@angular/core';
import { AppUser } from 'src/app/models/user.model';
import { Subscription } from 'rxjs';
import { Post } from 'src/app/models/post.model';
import { AuthService } from 'src/app/services/auth.service';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  posts: Post[];
  postsSubscription: Subscription;


  constructor(private authService: AuthService, private postService: PostService) { }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });

    this.postsSubscription = this.postService.$posts.subscribe(posts => {
      this.posts = posts;
    });
  }

  ngOnDestroy() {
    if (this.postsSubscription !== undefined) {
      this.postsSubscription.unsubscribe();
    }
  }
}
