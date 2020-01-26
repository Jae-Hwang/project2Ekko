import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AppUser } from '../models/user.model';
import { ReplaySubject, Subject } from 'rxjs';
import { Friendlist } from '../models/friendlist.model';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {

  friendlist = new Friendlist();

  private currentUserStream = new ReplaySubject<Friendlist>();
  $currentUser = this.currentUserStream.asObservable();

  constructor(private httpClient: HttpClient, private router: Router) {
    this.router.navigateByUrl('/friends');
  }

  save(credentials) {
    let au: Array<AppUser> = [new AppUser(0, credentials.username, '')];
    console.log(au);
    let fl = new Friendlist(152, au);
    console.log(fl);
    this.httpClient.post<Friendlist>('http://localhost:8080/ProjectEkko/friends/save', fl, {
      withCredentials: true
    }).subscribe(
      data => {
      },
      err => {
      }
    );
  }
}
