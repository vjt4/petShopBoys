import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, observable } from 'rxjs';
import { Pets } from '../models/pets';

@Injectable({
  providedIn: 'root',
})
export class SinglePetService {
  constructor(private http: HttpClient) {}

  getPet(id: number): Observable<Pets> {
    return this.http.post(
      'http://localhost:8080/PetShop/pet-by-id',
      id
    ) as Observable<Pets>;
  }
}
