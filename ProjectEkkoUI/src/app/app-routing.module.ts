import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { NewsComponent } from './pages/news/news/news.component';
import { SearchComponent } from './pages/food/search/search.component';
import { TestPageComponent } from './shared/test-page/test-page.component';

const routes: Routes = [
  {
    path: 'food',
    component: SearchComponent
  },
  {
    path: 'news',
    component: NewsComponent
  },
  {
    path: 'testpage',
    component: TestPageComponent
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
