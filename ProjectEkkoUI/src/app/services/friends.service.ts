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

  private currentUserStream = new ReplaySubject<Friendlist>(1);
  $currentUser = this.currentUserStream.asObservable();

  private currentFriendsStream = new ReplaySubject<AppUser[]>(1);
  $currentFriends = this.currentFriendsStream.asObservable();

  constructor(private httpClient: HttpClient, private router: Router) {
    this.router.navigateByUrl('/friends');

  }

  save(u, credentials) {
    const user = new AppUser(u, credentials.username, '****');
    this.httpClient.post<AppUser>('http://localhost:8080/ProjectEkko/friends/save', user, {
      withCredentials: true
    }).subscribe(
      data => {
        this.getFriends(u);
      },
      err => {
      }
    );
  }

  update(u, credentials) {
    const user = new AppUser(u, credentials.username, '****');
    this.httpClient.post<AppUser>('http://localhost:8080/ProjectEkko/friends/update', user, {
      withCredentials: true
    }).subscribe(
      data => {
        this.getFriends(u);
      },
      err => {
      }
    );
  }

  getFriends(uid) {
    this.httpClient.get<AppUser[]>(`http://localhost:8080/ProjectEkko/friends/${uid}`, {
      withCredentials: true
    }).subscribe(
      data => {
        this.currentFriendsStream.next(data);
      },
      err => {
      }
    );
  }

}
