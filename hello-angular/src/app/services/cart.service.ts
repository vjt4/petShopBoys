import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, observable } from 'rxjs';
import { Pets } from '../models/pets';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class CartService {

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
  
  }