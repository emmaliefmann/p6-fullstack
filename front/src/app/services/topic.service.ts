import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TopicList } from '../models/topicList.model';

@Injectable({
  providedIn: 'root'
})
export class TopicService {
  // todo, variable 
  private url = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  getAllTopics(): Observable<TopicList> {
    return this.http.get<any>(`${this.url}/topic`);
  }
}
