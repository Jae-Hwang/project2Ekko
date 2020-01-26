import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { NewsComponent } from './pages/news/news/news.component';
import { SearchComponent } from './pages/food/search/search.component';
import { ResultComponent } from './pages/food/result/result.component';

const routes: Routes = [
  {
    path: 'food',
    component: SearchComponent
  },
  {
    path: 'results',
    component: ResultComponent
  },
  {
    path: 'news',
    component: NewsComponent
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then(mod => mod.LoginModule)
  },
  {
    path: 'register',
    loadChildren: () => import('./pages/register/register.module').then(mod => mod.RegisterModule)
  },
  {
    path: 'friends',
    loadChildren: () => import('./pages/friends/friends.module').then(mod => mod.FriendsModule)
  },
  {
    path: '',
    component: PageNotFoundComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }