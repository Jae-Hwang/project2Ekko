import { Component, OnInit, OnDestroy } from '@angular/core';
import { RegisterService } from 'src/app/services/register.service';
import { Subscription } from 'rxjs';
import { Friendlist } from 'src/app/models/friendlist.model';
import { FriendsService } from 'src/app/services/friends.service';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit, OnDestroy {

  credentials = {
    username: ''
  };

  friends = new Friendlist();

  constructor(private friendService: FriendsService) { }

  ngOnInit() {
  }

  save() {
    this.friendService.save(this.credentials);
  }

  ngOnDestroy() {
  }
}
