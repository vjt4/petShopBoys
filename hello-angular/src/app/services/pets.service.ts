import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PetsService {
  private petArray = [];

  constructor(){}  

  setArrData(){
    this.petArray 
  }

  getArrData(){
   return this.petArray;
  }
}
