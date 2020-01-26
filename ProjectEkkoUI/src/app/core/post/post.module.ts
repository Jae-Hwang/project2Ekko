import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostComponent } from './components/post/post.component';
import { PostsContainerComponent } from './components/posts-container/posts-container.component';
import { ReactionComponent } from './components/reaction/reaction.component';
import { CommentsContainerComponent } from './components/comments-container/comments-container.component';
import { CommentComponent } from './components/comment/comment.component';
import { ReactionsContainerComponent } from './components/reactions-container/reactions-container.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CreateCommentComponent } from './components/create-comment/create-comment.component';
import { CreatePostComponent } from './components/create-post/create-post.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    PostComponent,
    CommentComponent,
    ReactionComponent,
    PostsContainerComponent,
    CommentsContainerComponent,
    ReactionsContainerComponent,
    CreateCommentComponent,
    CreatePostComponent
  ],
  imports: [
    CommonModule,
    NgbModule,
    FormsModule
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
