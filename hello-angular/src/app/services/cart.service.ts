import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, observable } from 'rxjs';
import { Pets } from '../models/pets';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  constructor(private http: HttpClient) {}

  items: Pets[] = [];

  addToCart(pets: Pets) {
    this.items.push(pets);
  }

  getItems() {
    return this.items;
  }

  clearCart() {
    this.items = [];
    return this.items;
  }

  purchase(cart: any): Observable<Pets> {
   // console.log(cart);
    return this.http.post(
      'http://localhost:8080/PetShop/checkout',
      cart
    ) as Observable<Pets>;
  }
}
