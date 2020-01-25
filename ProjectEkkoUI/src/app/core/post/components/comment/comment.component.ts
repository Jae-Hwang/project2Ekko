import { Component, OnInit, Input } from '@angular/core';
import { Comment } from 'src/app/models/comment.model';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  // tslint:disable-next-line: no-input-rename
  @Input('input-comment')
  comment: Comment;

  constructor() { }

  ngOnInit() {
  }

}
