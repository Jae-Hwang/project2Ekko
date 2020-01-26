import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostComponent } from './components/post/post.component';
import { PostsContainerComponent } from './components/posts-container/posts-container.component';
import { CommentsComponent } from './components/comment/comment.component';
import { ReactionComponent } from './components/reaction/reaction.component';



@NgModule({
  declarations: [
    PostComponent,
    PostsContainerComponent,
    CommentsComponent,
    ReactionComponent
  ],
  imports: [
    CommonModule
  ]
})
export class PostModule { }
