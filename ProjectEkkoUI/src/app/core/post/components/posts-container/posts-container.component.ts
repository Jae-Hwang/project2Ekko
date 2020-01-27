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

  targetUserSubscription: Subscription;
  targetUser: AppUser;

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  // tslint:disable-next-line: no-input-rename
  @Input('input-posts')
  posts: Post[];

  currentPage = 1;

  maxPageSubscription: Subscription;
  maxPage = 1;

  pageArray: number[];

  constructor(private postService: PostService, private authService: AuthService) { }

  pageType() {
    if (this.maxPage < 11) {
      return true;
    } else {
      return false;
    }
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

  selfFeed() {
    return (this.currentUser === this.targetUser);
  }

  postsFetched() {
    return (this.posts !== undefined);
  }

  clickPage(page: number) {
    this.currentPage = page;
    this.postService.getPostsByUserId(this.targetUser.id, this.currentPage);
  }

  clickLeft() {
    if (this.currentPage > 1) {
      this.currentPage -= 1;
      this.postService.getPostsByUserId(this.targetUser.id, this.currentPage);
    }
  }

  clickRight() {
    if (this.currentPage < this.maxPage) {
      this.currentPage += 1;
      this.postService.getPostsByUserId(this.targetUser.id, this.currentPage);
    }
  }

  dropdownClass(page: number) {
    if (page === this.currentPage) {
      return 'bg-dark text-white';
    } else {
      return 'bg-secondary text-white';
    }
  }

  setPageArray() {
    this.pageArray = new Array();

    for (let i = 1; i <= this.maxPage; i++) {
      this.pageArray.push(i);
    }
  }

  ngOnInit() {
    this.targetUserSubscription = this.authService.$targetUser.subscribe(user => {
      this.targetUser = user;
      console.log(`Requesting Posts of user: ${user.username}`);
      this.postService.getPostsByUserId(this.targetUser.id, 1);
    });

    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });

    this.maxPageSubscription = this.postService.$maxPage.subscribe(maxPage => {
      this.maxPage = maxPage;
      this.setPageArray();
    });
  }

  ngOnDestroy() {
    if (this.currentUserSubscription !== undefined) {
      this.currentUserSubscription.unsubscribe();
    }

    if (this.targetUserSubscription !== undefined) {
      this.targetUserSubscription.unsubscribe();
    }

    if (this.maxPageSubscription !== undefined) {
      this.maxPageSubscription.unsubscribe();
    }
  }

}
