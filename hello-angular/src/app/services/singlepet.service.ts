import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pets } from '../models/pets';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SinglepetService {
  constructor(private http: HttpClient) {}

  addCart(id: number): Observable<Pets> {
    return this.http.post(
      'http://localhost:8080/PetShop/add-to-cart',
      id
    ) as Observable<Pets>;
  }
}
