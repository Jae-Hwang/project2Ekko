import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { RegisterService } from 'src/app/services/register.service';

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

  constructor(private registerService: RegisterService) { }

  ngOnInit() {
    this.errorMessageSubscription = this.registerService.$registerError.subscribe(errorMessage => {
      this.errorMessage = errorMessage;
    });
  }

  register() {
    this.registerService.register(this.credentials);
  }


  ngOnDestroy() {
    this.errorMessageSubscription.unsubscribe();
  }

}