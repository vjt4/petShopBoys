import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, observable } from 'rxjs';
import { singlePet } from '../models/singlePet';

@Injectable({
  providedIn: 'root',
})
export class SinglePetService {
  constructor(private http: HttpClient) {}

  getPet(id: any): Observable<singlePet> {
    return this.http.post(
      'http://localhost:8080/PetShop/pet-by-id',
      id
    ) as Observable<singlePet>;
  }
}
