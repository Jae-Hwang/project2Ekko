import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { Post } from 'src/app/models/post.model';
import { AppUser } from 'src/app/models/user.model';
import { Comment } from 'src/app/models/comment.model';
import { Reaction } from 'src/app/models/reaction.model';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit, OnDestroy {

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  class = 'card';

  // tslint:disable-next-line: no-input-rename
  @Input('input-post')
  post: Post;

  constructor(private authService: AuthService) { }

  userOwned(post: Post) {
    if (post.owner.id === this.currentUser.id) {
      return '';
    }
  }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });
  }

  ngOnDestroy() {
    if (this.currentUserSubscription !== undefined || !this.currentUserSubscription.closed) {
      this.currentUserSubscription.unsubscribe();
    }
  }

}

