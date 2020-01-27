import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { AppUser } from 'src/app/models/user.model';
import { FriendsService } from 'src/app/services/friends.service';
import { Post } from 'src/app/models/post.model';
import { PostService } from 'src/app/services/post.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-friends-posts',
  templateUrl: './friends-posts.component.html',
  styleUrls: ['./friends-posts.component.css']
})
export class FriendsPostsComponent implements OnInit, OnDestroy {

  targetUserSubscription: Subscription;
  targetUser: AppUser;

  postsSubscription: Subscription;
  posts: Post[];

  constructor(private authService: AuthService, private postService: PostService) { }

  ngOnInit() {
    this.targetUserSubscription = this.authService.$targetUser.subscribe(user => {
      this.targetUser = user;
    });

    this.postsSubscription = this.postService.$posts.subscribe(posts => {
      this.posts = posts;
    });

  }

  ngOnDestroy() {
    if (this.targetUserSubscription !== undefined) {
      this.targetUserSubscription.unsubscribe();
    }

    if (this.postsSubscription !== undefined) {
      this.postsSubscription.unsubscribe();
    }
  }

}
