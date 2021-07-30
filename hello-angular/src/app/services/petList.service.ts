import { Injectable } from '@angular/core';
import samplePets from '../models/samplepets';
import { PetsInterface } from '../models/petsInterface';
import { JsonpClientBackend } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class petListService {
  constructor() {}

  getPetList(): PetsInterface[] {
    let obj = localStorage.getItem('pets') || '';
    if (obj == '') {
      console.log('Setting up pets for 1st time');
      localStorage.setItem('pets', JSON.stringify(samplePets));
      return samplePets;
    } else return JSON.parse(obj);
  }
}
