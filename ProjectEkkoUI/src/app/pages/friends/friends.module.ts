import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { FriendsComponent } from './components/friends/friends.component';
import { FriendsRoutingModule } from './friends-routing.module'

@NgModule({
  declarations: [FriendsComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    RouterModule,
    FriendsRoutingModule

  ]
})
export class FriendsModule { }