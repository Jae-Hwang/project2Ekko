import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DirMessageComponent } from './components/dir-message/dir-message.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MessageRoutingModule } from './message-routing.module';

@NgModule({
  declarations: [
    DirMessageComponent
  ],
  imports: [
    CommonModule,
    NgbModule,
    FormsModule,
    RouterModule,
    MessageRoutingModule
  ],
  exports: [
    DirMessageComponent
  ]
})
export class MessageModule { }
