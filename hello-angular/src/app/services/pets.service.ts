import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Pets } from '../models/pets';

@Injectable({
  providedIn: 'root'
})
export class PetsService {

  constructor(private http:HttpClient){} 

  getPets(id:number):Observable<Pets>{
    return this.http.get("http://localhost:8080/PetShop/pet") as Observable<Pets>
  }

}
