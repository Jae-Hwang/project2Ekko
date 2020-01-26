import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DirMessageComponent } from './components/dir-message/dir-message.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [
    DirMessageComponent
  ],
  imports: [
    CommonModule,
    NgbModule
  ],
  exports: [
    DirMessageComponent
  ]
})
export class MessageModule { }
