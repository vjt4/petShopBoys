import { Component, OnInit } from '@angular/core';
import { CheckboxControlValueAccessor } from '@angular/forms';
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

  public purchase: any = null;

  public animalId: number = 0;
  public name: string = '';
  public species: string = '';
  public breed: string = '';
  public age: string = '';
  public gender: string = '';
  public size: string = '';
  public price: number = 0;
  public picture: string = '';

  constructor(private CartService: CartService) {}

  ngOnInit(): void {
    this.getTotal();
  }
  checkout(): void {
    let cart: Pets =
     {
      animalId: 19,
      name: 'RUDY',
      species: 'fish',
      breed: 'Rottweiler',
      age: '3',
      gender: 'M',
      size: 'medium',
      price: 350.0,
      picture:
        'https://emeraldagro.com.ng/wp-content/uploads/2020/08/two-rottweiler-1.jpg',
    };

    console.log(cart);
    this.CartService.purchase(cart.animalId).subscribe(
      (data: Pets) => {
        this.purchase = data;
        console.log(this.purchase);
      },
      () => {
        console.log('we are experiencing a problem GD');
      }
    );
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
