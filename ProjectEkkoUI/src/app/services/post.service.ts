import { Injectable } from '@angular/core';
import { Post } from '../models/post.model';
import { ReplaySubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { PostDto } from '../models/postDto.model';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  cache = new Map<number, Post[]>();

  private maxPageStream = new ReplaySubject<number>(1);
  $maxPage = this.maxPageStream.asObservable();

  private postsStream = new ReplaySubject<Post[]>(1, 500);
  $posts = this.postsStream.asObservable();

  constructor(private httpClient: HttpClient) {
    console.log('post service is constructed.');
  }

  getPostsByUserId(uid: number, page: number) {
    if (this.cache.has(page)) {
      this.postsStream.next(this.cache.get(page));
    } else {
      this.httpClient.get<any>(`http://localhost:8080/ProjectEkko/posts/${uid}/${page}`, {
        withCredentials: true,
        observe: 'response'
      }).subscribe(
        data => {
          console.log(`successfully got posts with user id: ${uid} and page: ${page}`);
          this.postsStream.next(data.body);
          console.log(`Max Page: ${data.headers.get('X-page')}`);
          this.maxPageStream.next(parseInt(data.headers.get('X-page'), 0));
        },
        err => {
          console.log(`failed to get posts with user id: ${uid} and page: ${page}`);
          console.log(err);
        }
      );
    }
  }

  save(content: string, uid: number) {
    console.log(`Content: ${content}, uid: ${uid}`);
    const postDto = new PostDto(content, uid);
    const url = `http://localhost:8080/ProjectEkko/posts`;
    this.httpClient.post(url, postDto, {
      withCredentials: true
    }).subscribe(
      data => {
        console.log('Responded Okay');
        this.cache.clear();
      },
      err => {
        console.log(err);
      }
    );
  }
}
