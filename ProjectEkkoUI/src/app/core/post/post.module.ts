import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommentComponent } from './components/comment/comment.component';
import { CommentsContainerComponent } from './components/comments-container/comments-container.component';
import { CreateCommentComponent } from './components/create-comment/create-comment.component';
import { CreatePostComponent } from './components/create-post/create-post.component';
import { PostComponent } from './components/post/post.component';
import { PostsContainerComponent } from './components/posts-container/posts-container.component';
import { ReactionComponent } from './components/reaction/reaction.component';
import { ReactionsContainerComponent } from './components/reactions-container/reactions-container.component';



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
    ReactionsContainerComponent,
    CreateCommentComponent,
    CreatePostComponent
  ]
})
export class PostModule { }
