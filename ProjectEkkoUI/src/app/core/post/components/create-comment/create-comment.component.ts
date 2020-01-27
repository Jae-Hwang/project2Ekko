import { Component, Input, OnDestroy, OnInit, Output, EventEmitter } from '@angular/core';
import { Subscription } from 'rxjs';
import { Comment } from 'src/app/models/comment.model';
import { AppUser } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { CommentService } from 'src/app/services/comment.service';

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

  // tslint:disable-next-line: no-output-rename
  @Output('commentsChange')
  commentsChange = new EventEmitter<Comment[]>();

  content = '';

  placeholder = 'Enter New Comment!';

  constructor(private commentService: CommentService, private authService: AuthService) { }

  save() {
    if (this.content !== '') {
      this.commentService.save(this.content, this.currentUser.id, this.id);
      this.comments = [new Comment(0, this.content, this.currentUser, [], new Date())].concat(this.comments);
      this.commentsChange.emit(this.comments);
      this.content = '';
      this.placeholder = 'Enter New Comment!';
    } else {
      this.placeholder = 'Please Enter Something to Comment!';
    }
  }

  buttonActive() {
    if (this.content !== '') {
      return 'btn btn-secondary submit-button';
    } else {
      return 'btn btn-secondary submit-button disabled';
    }
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
