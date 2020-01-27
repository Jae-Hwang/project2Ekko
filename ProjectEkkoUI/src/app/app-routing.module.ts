import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { NewsComponent } from './pages/news/news/news.component';
import { SearchComponent } from './pages/food/search/search.component';
import { TestPageComponent } from './shared/test-page/test-page.component';
import { HomeComponent } from './shared/home/home.component';

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
    path: 'feed',
    component: TestPageComponent
  },
  {
    path: 'home',
    component: HomeComponent
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
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
