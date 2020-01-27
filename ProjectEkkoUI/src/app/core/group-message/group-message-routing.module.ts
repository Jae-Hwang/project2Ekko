import { Routes, RouterModule } from '@angular/router';
import { GroupMessageComponent } from './components/group-message/group-message.component';
import { NgModule } from '@angular/core';

const routes: Routes = [
    {
        path: '',
        component: GroupMessageComponent
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [
        RouterModule
    ]
})

export class GroupMessageRoutingModule { }
