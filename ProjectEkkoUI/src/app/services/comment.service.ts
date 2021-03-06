import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Comment } from '../models/comment.model';
import { AppUser } from '../models/user.model';
import { CommentDto } from '../models/commentDto.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private httpClient: HttpClient) { }

  save(content: string, uid: number, id: number) {
    console.log(`Content: ${content}, uid: ${uid}, pid: ${id}`);
    const commentDto = new CommentDto(content, uid);
    const url = `http://localhost:8080/ProjectEkko/comments/${id}`;
    this.httpClient.post(url, commentDto, {
      withCredentials: true
    }).subscribe(
      data => {
        console.log('Responded Okay');
      },
      err => {
        console.log(err);
      }
    );
  }

  getCommentsByPostIdAsObs(id: number) {
    console.log(`pid: ${id}`);
    return this.httpClient.get<Comment[]>(`http://localhost:8080/ProjectEkko/comments/${id}`);
  }
}
