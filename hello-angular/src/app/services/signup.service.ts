import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http:HttpClient) { }

  signUp(userCredentials:any): Observable<User>{
    return this.http.post('http://localhost:8080/PetShop/create-account', userCredentials) as Observable<User>
  }
}