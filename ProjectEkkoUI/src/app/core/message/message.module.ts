import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DirMessageComponent } from './components/dir-message/dir-message.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MessageRoutingModule } from './message-routing.module';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    DirMessageComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    RouterModule,
    MessageRoutingModule
  ]
})
export class MessageModule { }
