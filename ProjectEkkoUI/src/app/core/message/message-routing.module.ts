import { Routes, RouterModule } from '@angular/router';
import { NgModule, Component } from '@angular/core';
import { DirMessageComponent } from './components/dir-message/dir-message.component';

const routes: Routes = [
    {
        path: '',
        component: DirMessageComponent
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

export class MessageRoutingModule { }
