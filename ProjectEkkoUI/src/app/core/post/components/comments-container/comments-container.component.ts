import { Component, OnInit, Input } from '@angular/core';
import { Comment } from 'src/app/models/comment.model';

@Component({
  selector: 'app-comments-container',
  templateUrl: './comments-container.component.html',
  styleUrls: ['./comments-container.component.css']
})
export class CommentsContainerComponent implements OnInit {

  // tslint:disable-next-line: no-input-rename
  @Input('input-comments')
  comments: Comment[];

  // tslint:disable-next-line: no-input-rename
  @Input('input-id')
  id: number;

  constructor() { }

  ngOnInit() {
  }

}
