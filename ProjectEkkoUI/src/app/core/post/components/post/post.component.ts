import { Component, OnInit, Input } from '@angular/core';
import { Post } from 'src/app/models/post.model';
import { AppUser } from 'src/app/models/user.model';
import { Comment } from 'src/app/models/comment.model';
import { Reaction } from 'src/app/models/reaction.model';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  // tslint:disable-next-line: no-input-rename
  @Input('input-post')
  post: Post;

  constructor() { }

  ngOnInit() {
  }

}
