import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AppUser } from '../models/user.model';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private registerErrorStream = new Subject<string>();
  $registerError = this.registerErrorStream.asObservable();

  constructor(private httpClient: HttpClient, private router: Router) {
    this.router.navigateByUrl('/register');
  }

  register(credentials) {
    this.httpClient.post<AppUser>('http://localhost:8080/ProjectEkko/register', credentials, {
      withCredentials: true
    }).subscribe(
      data => {
      },
      err => {
        this.registerErrorStream.next('Failed to Register');
      }
    );
  }
}
