import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Comment } from 'src/app/models/comment.model';
import { Post } from 'src/app/models/post.model';
import { AppUser } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { trigger, transition, style, animate } from '@angular/animations';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
  animations: [
    trigger('fade', [
      transition('void => *', [
        style({ opacity: 0 }),
        animate(500, style({ opacity: 1 }))
      ])
    ])
  ]
})
export class PostComponent implements OnInit, OnDestroy {

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  class = 'card';

  // tslint:disable-next-line: no-input-rename
  @Input('input-post')
  post: Post;

  constructor(private authService: AuthService) { }

  userOwned() {
    if (this.post.owner.id === this.currentUser.id) {
      this.class = 'card owned-card';
    }
  }

  commentsChange(comments: Comment[]) {
    this.post.comments = comments;
  }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });

    this.userOwned();
  }

  ngOnDestroy() {
    if (this.currentUserSubscription !== undefined) {
      this.currentUserSubscription.unsubscribe();
    }
  }

}

