import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FriendsPostsComponent } from './components/friends-posts/friends-posts.component';
import { FriendsComponent } from './components/friends/friends.component';

const routes: Routes = [
    {
        path: '',
        component: FriendsComponent
    },
    {
        path: 'feed',
        component: FriendsPostsComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class FriendsRoutingModule { }