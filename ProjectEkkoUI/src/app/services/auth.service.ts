import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AppUser } from '../models/user.model';
import { ReplaySubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user = new AppUser(0, null, null);

  private currentUserStream = new ReplaySubject<AppUser>(1);
  $currentUser = this.currentUserStream.asObservable();

  private targetUserStream = new ReplaySubject<AppUser>(1);
  $targetUser = this.targetUserStream.asObservable();

  private loginErrorStream = new Subject<string>();
  $loginError = this.loginErrorStream.asObservable();


  constructor(private httpClient: HttpClient, private router: Router) {
    this.router.navigateByUrl('/login');
  }

  setTargetUser(user: AppUser) {
    this.targetUserStream.next(user);
  }

  login(credentials) {
    this.httpClient.post<AppUser>('http://localhost:8080/ProjectEkko/login', credentials, {
      withCredentials: true
    }).subscribe(
      data => {
        if (data.username !== null) {
          this.router.navigateByUrl('feed');
          this.user = data;
          this.currentUserStream.next(data);
        } else {
          this.loginErrorStream.next('Failed to Login');
        }
      },
      err => {
        this.loginErrorStream.next('Failed to Login');
      }
    );
  }

  logout() {
    this.currentUserStream.next(null);
    this.router.navigateByUrl('/login');
    this.user = new AppUser(0, null, null);
  }

  checkuser() {
    if (this.user.username === undefined || this.user.username == null) {
      return false;
    } else {
      return true;
    }
  }
}
