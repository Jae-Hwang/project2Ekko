import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewsComponent } from './news/news.component';
import { NewsBarComponent } from './news-bar/news-bar.component';



@NgModule({
  declarations: [NewsComponent, NewsBarComponent],
  imports: [
    CommonModule
  ]
})
export class NewsModule { }
