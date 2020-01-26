import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostComponent } from './components/post/post.component';
import { PostsContainerComponent } from './components/posts-container/posts-container.component';
import { ReactionComponent } from './components/reaction/reaction.component';
import { CommentsContainerComponent } from './components/comments-container/comments-container.component';
import { CommentComponent } from './components/comment/comment.component';
import { ReactionsContainerComponent } from './components/reactions-container/reactions-container.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [
    PostComponent,
    CommentComponent,
    ReactionComponent,
    PostsContainerComponent,
    CommentsContainerComponent,
    ReactionsContainerComponent
  ],
  imports: [
    CommonModule,
    NgbModule
  ],
  exports: [
    PostComponent,
    CommentComponent,
    ReactionComponent,
    PostsContainerComponent,
    CommentsContainerComponent,
    ReactionsContainerComponent
  ]
})
export class PostModule { }
