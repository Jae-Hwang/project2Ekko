import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Subscription } from 'rxjs';
import { AppUser } from 'src/app/models/user.model';
import { DirMsgService } from 'src/app/services/dir-msg.service';
import { DirMessage } from 'src/app/models/dir-msg.model';

@Component({
  selector: 'app-dir-message',
  templateUrl: './dir-message.component.html',
  styleUrls: ['./dir-message.component.css']
})
export class DirMessageComponent implements OnInit {

  credentials = {
    id: 0
  };

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  dirMessages = {
    user1Id: 0,
    user2Id: 0,
    message: ''
  };

  allDirMsgs: DirMessage[] = [];
  dmSubscription: Subscription;

  constructor(private authService: AuthService, private dirMsgService: DirMsgService) { }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });

    this.dirMsgService.getOldDMs(this.currentUser.id);
    this.dmSubscription = this.dirMsgService.$currentDMs.subscribe(dms => {
      this.allDirMsgs = dms;
    });
  }

  // getOldDMs() {
  //   this.dirMsgService.getOldDMs(this.currentUser.id);
  // }

  createNewDM() {
    this.dirMessages.user1Id = this.currentUser.id;
    this.dirMsgService.createNewDM(this.dirMessages);
  }

}
