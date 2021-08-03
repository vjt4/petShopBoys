import { Component, OnInit } from '@angular/core';
import { Pets } from 'src/app/models/pets';
import { CartService } from 'src/app/services/cart.service';
import { PetsService } from 'src/app/services/pets.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  items = this.CartService.getItems();
  totalamount = 0;

  constructor(private CartService: CartService) {}

  ngOnInit(): void {
    this.getTotal();
    //let cart: Pets = {

    //}
  }

  getTotal() {
    let total = 0;

    for (var i = 0; i < this.items.length; i++) {
      if (this.items[i].price) {
        total += this.items[i].price;
        this.totalamount = total;
      }
    }
    console.log(total);
    return total;
  }
}
