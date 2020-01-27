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

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  currentTable: AppUser[];
  tableSubscription: Subscription;

  count = 0;

  constructor(private friendService: FriendsService, private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });
    let check = this.authService.checkuser();
    if (check === false) {
      this.router.navigateByUrl('/login');
    }
    this.friendService.getFriends(this.currentUser.id);
    this.tableSubscription = this.friendService.$currentFriends.subscribe(user => {
      this.currentTable = user;
    });
    console.log(this.currentTable);
  }

  submit() {
    this.count = this.currentTable.length;
    if (this.count > 1) {
      this.friendService.update(this.currentUser.id, this.credentials);
    } else {
      this.friendService.save(this.currentUser.id, this.credentials);
    }
  }

  ngOnDestroy() {
    if (this.currentUserSubscription !== undefined) {
      this.currentUserSubscription.unsubscribe();
    }
  }
}
