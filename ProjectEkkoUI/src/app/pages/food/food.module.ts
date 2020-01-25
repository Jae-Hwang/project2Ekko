import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchComponent } from './search/search.component';
import { FormsModule } from '@angular/forms';
import { SearchService } from './search/search.service';

@NgModule({
  declarations: [
    SearchComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  providers: [
    SearchService
  ],
  exports: [
    SearchComponent
  ]
})
export class FoodModule { }
