import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Post } from 'src/app/models/post.model';
import { AppUser } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-posts-container',
  templateUrl: './posts-container.component.html',
  styleUrls: ['./posts-container.component.css'],
})
export class PostsContainerComponent implements OnInit, OnDestroy {

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  // tslint:disable-next-line: no-input-rename
  @Input('input-posts')
  posts: Post[];

  currentPage = 2;
  maxPage = 13;
  pageArray: number[];

  constructor(private postService: PostService, private authService: AuthService) { }

  pageType() {
    if (this.maxPage < 11) {
      return true;
    } else {
      return false;
    }
  }

  postsChange(posts: Post[]) {
    this.posts = posts;
  }

  pageChange(page: number) {
    this.currentPage = 1;
  }

  buttonClass(page: number) {
    if (page === this.currentPage) {
      return 'btn btn-dark';
    } else {
      return 'btn btn-secondary';
    }
  }

  clickPage(page: number) {
    this.currentPage = page;
    this.postService.getPostsByUserId(this.currentUser.id, this.currentPage);
  }

  clickLeft() {
    if (this.currentPage > 1) {
      this.currentPage -= 1;
      this.postService.getPostsByUserId(this.currentUser.id, this.currentPage);
    }
  }

  clickRight() {
    if (this.currentPage < this.maxPage) {
      this.currentPage += 1;
      this.postService.getPostsByUserId(this.currentUser.id, this.currentPage);
    }
  }

  dropdownClass(page: number) {
    if (page === this.currentPage) {
      return 'bg-dark text-white';
    } else {
      return 'bg-secondary text-white';
    }
  }

  postsFetched() {
    return (this.posts !== undefined);
  }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
      this.postService.getPostsByUserId(this.currentUser.id, 1);
    });
    this.pageArray = new Array();

    for (let i = 1; i <= this.maxPage; i++) {
      this.pageArray.push(i);
    }
  }

  ngOnDestroy() {
    if (this.currentUserSubscription !== undefined) {
      this.currentUserSubscription.unsubscribe();
    }
  }

}
