import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { Observable, observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {

  constructor(private http:HttpClient) { }

    logout(userCredentials:any): Observable<User>{
      return this.http.post('http://localhost:8080/PetShop/logout', userCredentials) as Observable<User>
    }
}