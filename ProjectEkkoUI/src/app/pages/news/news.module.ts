import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewsComponent } from './news/news.component';
import { NewsBarComponent } from './news-bar/news-bar.component';
import { FormsModule } from '@angular/forms';
import { NewsService } from './news.service';



@NgModule({
  declarations: [
    NewsComponent,
    NewsBarComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  providers: [
    NewsService
  ],
  exports: [
    NewsComponent,
    NewsBarComponent
  ]
})
export class NewsModule { }
