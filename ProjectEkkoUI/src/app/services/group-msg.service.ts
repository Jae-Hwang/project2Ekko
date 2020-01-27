import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { GroupChat } from '../models/group-chat.model';
import { GroupChatMessage } from '../models/group-chat-message.model';

@Injectable({
  providedIn: 'root'
})
export class GroupMsgService {

  // private currentDMsStream = new ReplaySubject<DirMessage[]>();
  // $currentDMs = this.currentDMsStream.asObservable();

  constructor(private httpClient: HttpClient, private router: Router) { }

  createNewGC(newGroupChats) {
    this.httpClient.post<GroupChat>(`http://localhost:8080/ProjectEkko/groupChat/create`, newGroupChats, {
      withCredentials: true
    }).subscribe(
      data => {
        console.log(data);
      },
      err => {
        console.log('You dont have enough badges for that');
      }
    );
  }

  addNewUserToGC(chatToAssign, userToBeAssigned) {
    this.httpClient.post<GroupChat>(`http://localhost:8080/ProjectEkko/groupChat/addUser`, [chatToAssign, userToBeAssigned], {
      withCredentials: true
    }).subscribe(
      data => {
        console.log(data);
      },
      err => {
        console.log('You done goofed, but thats okay');
      }
    );
  }

  addNewMsgToGC(msgToSend) {
    this.httpClient.post<GroupChatMessage>(`http://localhost:8080/ProjectEkko/groupChat/addMsg`, msgToSend, {
      withCredentials: true
    }).subscribe(
      data => {
        console.log(data);
      },
      err => {
        console.log('Nah b, try again');
      }
    );
  }
}
