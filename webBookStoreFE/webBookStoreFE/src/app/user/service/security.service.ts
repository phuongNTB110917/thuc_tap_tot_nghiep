import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoginRequest} from '../../model/login-request';
import {ResponseMessage} from '../../model/response-message';
import {RegisterRequest} from '../../model/register-request';

const API_URL_AUTH = 'http://localhost:8080/api/auth';
@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  httpOptions: any;

  constructor(private http: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
  }

  login(obj): Observable<any> {
    return this.http.post(API_URL_AUTH + '/signin', {
      username: obj.username,
      password: obj.password
    }, this.httpOptions);
  }

  signup(registerRequest: RegisterRequest): Observable<ResponseMessage> {
    return this.http.post<ResponseMessage>(API_URL_AUTH + '/signup', registerRequest);

  }

}
