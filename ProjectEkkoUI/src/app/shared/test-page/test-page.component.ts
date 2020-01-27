import { Component, OnInit, OnDestroy } from '@angular/core';
import { Reaction } from 'src/app/models/reaction.model';
import { AppUser } from 'src/app/models/user.model';
import { Comment } from 'src/app/models/comment.model';
import { Post } from 'src/app/models/post.model';
import { PostService } from 'src/app/services/post.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-test-page',
  templateUrl: './test-page.component.html',
  styleUrls: ['./test-page.component.css']
})
export class TestPageComponent implements OnInit, OnDestroy {

  testPosts: Post[];
  postsSubscription: Subscription;


  constructor(private postService: PostService) { }

  ngOnInit() {
    this.postsSubscription = this.postService.$posts.subscribe(posts => {
      this.testPosts = posts;
    });
  }

  ngOnDestroy() {
    if (this.postsSubscription !== undefined) {
      this.postsSubscription.unsubscribe();
    }
  }

}
