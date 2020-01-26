import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DirMessage } from '../models/dir-msg.model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class DirMsgService {

  constructor(private httpClient: HttpClient, private router: Router) { }

  createNewDM(dirMessages) {
    this.httpClient.post<DirMessage>(`http://localhost:8080/ProjectEkko/directMsg/save`, dirMessages, {
      withCredentials: true
    }).subscribe(
      data => {
        this.router.navigateByUrl('/home');
      },
      err => {
        console.log('You messsed up');
      }
    );
  }
}
