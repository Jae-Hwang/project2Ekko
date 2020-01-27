import { Component, OnInit } from '@angular/core';
import { AppUser } from 'src/app/models/user.model';
import { Subscription } from 'rxjs';
import { GroupChatMessage } from 'src/app/models/group-chat-message.model';
import { AuthService } from 'src/app/services/auth.service';
import { GroupMsgService } from 'src/app/services/group-msg.service';
import { GroupChat } from 'src/app/models/group-chat.model';

@Component({
  selector: 'app-group-message',
  templateUrl: './group-message.component.html',
  styleUrls: ['./group-message.component.css']
})
export class GroupMessageComponent implements OnInit {

  credentials = {
    id: 0
  };

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  newGroupChats = {
    chatName: '',
    userList: AppUser[this.credentials.id]
  };

  chatToAssign = {
    id: 0
  };

  userToBeAssigned = {
    id: 0
  };

  msgToSend = {
    chatMessge: '',
    groupChat: GroupChat[this.chatToAssign.id]
  };

  allChatMsgs: GroupChatMessage[] = [];
  chatMsgSubscription: Subscription;

  allUsers: AppUser[] = [];
  userSubscription: Subscription;

  constructor(private authService: AuthService, private groupMsgService: GroupMsgService) { }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });
    // Get function to come
  }

  createNewGC() {
    this.newGroupChats.userList = this.currentUser.id;
    this.groupMsgService.createNewGC(this.newGroupChats);
  }

  addNewUserToGC() {
    this.groupMsgService.addNewUserToGC(this.chatToAssign, this.userToBeAssigned);
  }

  addNewMsgToGC() {
    this.msgToSend.groupChat = this.chatToAssign.id;
    this.groupMsgService.addNewMsgToGC(this.msgToSend);
  }
}
