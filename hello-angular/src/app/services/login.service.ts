import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  loginUser(userCredentials: any): Observable<User> {
    console.log(userCredentials);
    return this.http.post(
      'http://localhost:8080/PetShop/login',
      userCredentials
    ) as Observable<User>;
  }
}
