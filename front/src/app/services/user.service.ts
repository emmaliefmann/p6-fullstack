import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserRegistration } from '../models/UserRegistration.model';
import { Observable } from 'rxjs';
import { UserInfo } from '../models/userInfo.model';
import { Login } from '../models/Login.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  registerUser(user: UserRegistration): Observable<UserInfo> {
    return this.http.post<UserInfo>(`${this.url}/auth/register`, user);
  }

  login(login: Login): Observable<string> {
    return this.http.post<string>(`${this.url}/auth/login`, login);
  }
}
