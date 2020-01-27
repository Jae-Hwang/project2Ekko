import { Component, OnInit, Input, Output, EventEmitter, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { AppUser } from 'src/app/models/user.model';
import { Post } from 'src/app/models/post.model';
import { PostService } from 'src/app/services/post.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit, OnDestroy {

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  // tslint:disable-next-line: no-input-rename
  @Input('input-posts')
  posts: Post[];

  // tslint:disable-next-line: no-output-rename
  @Output('postsChange')
  postsChange = new EventEmitter<Post[]>();

  // tslint:disable-next-line: no-output-rename
  @Output('pageChange')
  pageChange = new EventEmitter<number>();

  content = '';

  placeholder = 'Enter New Post!';

  constructor(private authService: AuthService, private postService: PostService) { }

  save() {
    if (this.content !== '') {
      this.postService.save(this.content, this.currentUser.id);
      // this.posts = [new Post(0, this.content, this.currentUser, [], [], new Date())].concat(this.posts);
      // this.postsChange.emit(this.posts);
      this.content = '';
      this.placeholder = 'Enter New Post!';

      setTimeout(() => this.postService.getPostsByUserId(this.currentUser.id, 1), 100);
      this.pageChange.emit(1);
    } else {
      this.placeholder = 'Please Enter Something to Post!';
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
