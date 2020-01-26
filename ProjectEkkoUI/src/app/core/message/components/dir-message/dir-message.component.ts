import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Subscription } from 'rxjs';
import { AppUser } from 'src/app/models/user.model';
import { DirMsgService } from 'src/app/services/dir-msg.service';
import { DirMessage } from 'src/app/models/dir-msg.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dir-message',
  templateUrl: './dir-message.component.html',
  styleUrls: ['./dir-message.component.css']
})
export class DirMessageComponent implements OnInit {

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  dirMessages = {
    user1Id: this.currentUser.id,
    user2Id: 0,
    message: ''
  };

  allDirMsgs: DirMessage[] = [];

  constructor(private authService: AuthService, private dirMsgService: DirMsgService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });

    this.httpClient.get<DirMessage[]>(`http://localhost:8080/ProjectEkko/directMsg/{uid}`, {
      withCredentials: true
    }).subscribe(data => {
      this.allDirMsgs = data;
    },
    err => {
      console.log('No dms, sad emoji ');
    });
  }

  createNewDM() {
    this.dirMsgService.createNewDM(this.dirMessages);
  }

}
