import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AppUser } from '../models/user.model';
import { ReplaySubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: AppUser = null;

  private currentUserStream = new ReplaySubject<AppUser>(1);
  $currentUser = this.currentUserStream.asObservable();

  private loginErrorStream = new Subject<string>();
  $loginError = this.loginErrorStream.asObservable();


  constructor(private httpClient: HttpClient, private router: Router) {
    this.router.navigateByUrl('/login');
  }

  login(credentials) {
    this.httpClient.post<AppUser>('http://localhost:8080/ProjectEkko/login', credentials, {
      withCredentials: true
    }).subscribe(
      data => {
        if (data.username !== null) {
        this.router.navigateByUrl('');
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
    if (this.user !== null || this.user.username !== null) {
      this.currentUserStream.next(null);
      this.router.navigateByUrl('');
    }
  }

}
