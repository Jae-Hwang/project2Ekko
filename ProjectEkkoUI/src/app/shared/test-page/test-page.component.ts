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

  user1 = new AppUser(152, 'User1', 'pass');
  user2 = new AppUser(153, 'User2', 'pass');
  user3 = new AppUser(1052, 'User3', 'pass');

  reactionsComment1: Reaction[] = [
    new Reaction(1, this.user3, 1),
    new Reaction(2, this.user3, 2),
    new Reaction(7, this.user3, 2),
    new Reaction(8, this.user3, 2),
    new Reaction(9, this.user3, 2)
  ];

  reactionsComment2: Reaction[] = [
    new Reaction(5, this.user3, 5),
    new Reaction(6, this.user3, 6)
  ];

  comments: Comment[] = [
    new Comment(1, 'This is test Comment1 for Post1', this.user2, this.reactionsComment1, new Date()),
    new Comment(2, 'This is test Comment2 for Post1', this.user2, this.reactionsComment2, new Date())
  ];

  reactionsPost: Reaction[] = [
    new Reaction(3, this.user3, 3),
    new Reaction(4, this.user3, 4)
  ];

  testPost = new Post(1, 'This is Post1!', this.user1, this.comments, this.reactionsPost, new Date());

  testPosts: Post[];
  postsSubscription: Subscription;


  constructor(private postService: PostService) { }

  ngOnInit() {
    this.postsSubscription = this.postService.$posts.subscribe(posts => {
      this.testPosts = posts;
    });
    this.postService.getPostsByUserId(153, 1);
  }

  ngOnDestroy() {
    if (this.postsSubscription !== undefined) {
      this.postsSubscription.unsubscribe();
    }
  }
}
