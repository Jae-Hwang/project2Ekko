import { Component, Input, OnInit, OnDestroy } from '@angular/core';
import { CommentService } from 'src/app/services/comment.service';
import { Subscription } from 'rxjs';
import { AppUser } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { Comment } from 'src/app/models/comment.model';

@Component({
  selector: 'app-create-comment',
  templateUrl: './create-comment.component.html',
  styleUrls: ['./create-comment.component.css']
})
export class CreateCommentComponent implements OnInit, OnDestroy {

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  // tslint:disable-next-line: no-input-rename
  @Input('input-comments')
  comments: Comment[];

  // tslint:disable-next-line: no-input-rename
  @Input('input-id')
  id: number;

  content = '';

  constructor(private commentService: CommentService, private authService: AuthService) { }

  save() {
    if (this.content !== '') {
      this.commentService.save(this.content, this.currentUser.id, this.id);
    }
    this.comments = [new Comment(0, this.content, this.currentUser, [], new Date())].concat(this.comments);
    console.log(this.comments);
  }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });
  }

  ngOnDestroy() {
    if (this.currentUserSubscription !== undefined) {
      this.currentUserSubscription.unsubscribe();
    }
  }

}
