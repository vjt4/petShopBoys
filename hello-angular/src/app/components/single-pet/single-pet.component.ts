import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AllPetsComponent } from '../all-pets/all-pets.component';
import { Pets } from 'src/app/models/pets';
import { PetsService } from 'src/app/services/pets.service';

@Component({
  selector: 'app-single-pet',
  templateUrl: './single-pet.component.html',
  styleUrls: ['./single-pet.component.css'],
})
export class SinglePetComponent implements OnInit {
  
  public pet:any = null;
  public currentRoute:any = this.Router.url.slice(16);
  public petRoute = this.currentRoute - 1;

  public animalId:number = 0;
  public name:string = "";
  public species:string = "";
  public breed:string = "";
  public age:string = "";
  public gender:string = "";
  public size:string = "";
  public price:number = 0;
  public picture:string = "";
  
  constructor(
    private route: ActivatedRoute,
    private petsService: PetsService,
    private Router: Router
  ) {}

  ngOnInit(): void {
    this.displayPet()
  }

  displayPet():void {
    
    this.petsService.getPets(this.pet).subscribe(
      (data:Pets) => {
        this.pet = data;
        console.log(this.pet);
      },

      () => {
        this.pet = null;
        console.log("couldn't get pet")
      }
    )
  }
}
