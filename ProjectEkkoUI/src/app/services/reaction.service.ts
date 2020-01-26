import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ReactionDto } from '../models/reactionDto.model';

@Injectable({
  providedIn: 'root'
})
export class ReactionService {

  constructor(private httpClient: HttpClient) { }

  save(type: string, uid: number, id: number, reactionType: number) {
    const reaction = new ReactionDto(uid, reactionType)
    let url = '';
    if (type === 'post') {
      url = `http://localhost:8080/ProjectEkko/reactions/posts/${id}`;
    } else if (type === 'comment') {
      url = `http://localhost:8080/ProjectEkko/reactions/comments/${id}`;
    } else {
      console.log('Something went very weirdly wrong');
      return;
    }
    this.httpClient.post(url, reaction, {
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

  delete(type: string, uid: number, id: number) {
    let url = '';
    if (type === 'post') {
      url = `http://localhost:8080/ProjectEkko/reactions/posts/${uid}/${id}`;
    } else if (type === 'comment') {
      url = `http://localhost:8080/ProjectEkko/reactions/comments/${uid}/${id}`;
    } else {
      console.log('Something went very weirdly wrong');
      return;
    }
    this.httpClient.delete(url, {
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


}
