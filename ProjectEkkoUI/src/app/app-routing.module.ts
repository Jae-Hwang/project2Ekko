import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { NewsComponent } from './news/news/news.component';
import { SearchComponent } from './food/search/search.component';
import { ResultComponent } from './food/result/result.component';

const routes: Routes = [
  {path: 'food', component: SearchComponent},
  {path: 'results', component: ResultComponent},
  {path: 'news', component: NewsComponent},
  {path: '**' , component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }