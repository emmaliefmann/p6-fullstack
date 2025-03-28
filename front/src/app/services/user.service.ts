import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserRegistration } from '../models/UserRegistration.model';
import { Observable } from 'rxjs';
import { UserInfo } from '../models/userInfo.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  registerUser(user: UserRegistration): Observable<UserInfo> {
    return this.http.post<UserInfo>(`${this.url}/auth/register`, user);
  }
}
