import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GroupMessageComponent } from './components/group-message/group-message.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { GroupMessageRoutingModule } from './group-message-routing.module';



@NgModule({
  declarations: [
    GroupMessageComponent
  ],
  imports: [
    CommonModule,
    NgbModule,
    FormsModule,
    RouterModule,
    GroupMessageRoutingModule
  ],
  exports: [
    GroupMessageComponent
  ]
})
export class GroupMessageModule { }
