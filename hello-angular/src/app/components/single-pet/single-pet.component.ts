import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AllPetsComponent } from '../all-pets/all-pets.component';
import { PetsInterface } from 'src/app/models/petsInterface';
import { petListService } from 'src/app/services/petList.service';
import { Pets } from 'src/app/models/pets';

@Component({
  selector: 'app-single-pet',
  templateUrl: './single-pet.component.html',
  styleUrls: ['./single-pet.component.css'],
})
export class SinglePetComponent implements OnInit {
  public animalId: number = 0;
  public name: string = '';
  public species: string = '';
  public breed: string = '';
  public age: string = '';
  public gender: string = '';
  public size: string = '';
  public price: number = 0;
  public picture: string = '';

  //@Input() data: any[];

  constructor(
    private route: ActivatedRoute,
    private petListService: petListService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  getPet(): void {
    let id: Pets = {
      animalId: this.animalId,
      //name: this.name,
      //species: this.species,
      //breed: this.breed,
      //age: this.age,
      // gender: this.gender,
      // size: this.size,
      // price: this.price,
      // picture: this.picture,
    };
    this.petListService.getPet(id).subscribe((data: Pets) => {
      this.pet = data;
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
