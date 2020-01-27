import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DirMessage } from '../models/dir-msg.model';
import { Router } from '@angular/router';
import { ReplaySubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DirMsgService {

  private currentDMsStream = new ReplaySubject<DirMessage[]>();
  $currentDMs = this.currentDMsStream.asObservable();

  constructor(private httpClient: HttpClient, private router: Router) { }

  createNewDM(dirMessages) {
    this.httpClient.post<DirMessage>(`http://localhost:8080/ProjectEkko/directMsg/save`, dirMessages, {
      withCredentials: true
    }).subscribe(
      data => {
        this.getOldDMs(dirMessages.user1Id);
      },
      err => {
        console.log('You messsed up');
      }
    );
  }

  getOldDMs(uid) {
    console.log(uid);
    this.httpClient.get<DirMessage[]>(`http://localhost:8080/ProjectEkko/directMsg/${uid}`, {
      withCredentials: true
    }).subscribe(data => {
      console.log(data);
      this.currentDMsStream.next(data);
    },
    err => {
      console.log('No dms, sad emoji ');
    }
    );
  }
}
