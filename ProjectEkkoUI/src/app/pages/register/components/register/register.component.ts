import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { RegisterService } from 'src/app/services/register.service';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit, OnDestroy {

  credentials = {
    username: '',
    password: ''
  };
  errorMessage = '';
  errorMessageSubscription: Subscription;

  constructor(private registerService: RegisterService, private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.errorMessageSubscription = this.registerService.$registerError.subscribe(errorMessage => {
      this.errorMessage = errorMessage;
    });
    let check = this.authService.checkuser();
    if (check === true) {
      this.router.navigateByUrl('');
    }
  }

  register() {
    this.registerService.register(this.credentials);
  }


  ngOnDestroy() {
    this.errorMessageSubscription.unsubscribe();
  }

}