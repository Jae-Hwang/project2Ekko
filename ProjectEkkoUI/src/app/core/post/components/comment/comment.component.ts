import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { Comment } from 'src/app/models/comment.model';
import { AppUser } from 'src/app/models/user.model';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit, OnDestroy {

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  class = 'card';

  // tslint:disable-next-line: no-input-rename
  @Input('input-comment')
  comment: Comment;

  // tslint:disable-next-line: no-input-rename
  @Input('input-id')
  id: number;

  constructor(private authService: AuthService) { }

  userOwned() {
    if (this.comment.owner.id === this.currentUser.id) {
      this.class = 'card owned-card';
    }
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
