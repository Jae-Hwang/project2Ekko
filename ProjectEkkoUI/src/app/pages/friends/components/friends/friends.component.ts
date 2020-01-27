import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { FriendsService } from 'src/app/services/friends.service';
import { AppUser } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit, OnDestroy {

  credentials = {
    username: ''
  };

  targetUserSubscription: Subscription;
  targetUser: AppUser;

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  currentTable: AppUser[];
  tableSubscription: Subscription;

  count = 0;

  constructor(private friendService: FriendsService, private authService: AuthService, private router: Router) { }

  submit() {
    if (this.currentTable === undefined) {
      this.friendService.save(this.currentUser.id, this.credentials);
    } else {
      this.friendService.update(this.currentUser.id, this.credentials);
    }
    this.credentials.username = '';
  }

  clickFriend(user: AppUser) {
    this.authService.setTargetUser(user);
    this.router.navigateByUrl('/friends/feed');
  }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });
    const check = this.authService.checkuser();
    if (check === false) {
      this.router.navigateByUrl('/login');
    }
    this.friendService.getFriends(this.currentUser.id);
    this.tableSubscription = this.friendService.$currentFriends.subscribe(user => {
      this.currentTable = user;
    });
  }

  ngOnDestroy() {
    if (this.currentUserSubscription !== undefined) {
      this.currentUserSubscription.unsubscribe();
    }

    if (this.tableSubscription !== undefined) {
      this.tableSubscription.unsubscribe();
    }
  }
}
