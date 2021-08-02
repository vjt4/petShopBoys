import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AllPetsComponent } from '../all-pets/all-pets.component';
import { PetsInterface } from 'src/app/models/petsInterface';
import { petListService } from 'src/app/services/petList.service';

@Component({
  selector: 'app-single-pet',
  templateUrl: './single-pet.component.html',
  styleUrls: ['./single-pet.component.css'],
})
export class SinglePetComponent implements OnInit {
  animalId: number;
  pet: PetsInterface;
  dummyPet: PetsInterface;
  sub: any;
  //let pets: Array<any> = AllPetsComponent.petArray;

  //@Input() data: any[];

  constructor(
    private route: ActivatedRoute,
    private petListService: petListService
  ) {
    this.animalId = 0;
    this.pet = {
      animalId: 1,
      name: '',
      species: '',
      breed: '',
      age: '',
      gender: '',
      size: '',
      price: 1,
      picture: '',
    };
    this.dummyPet = this.pet;
  }

  ngOnInit(): void {
    console.log('single-pet component mounted again');
    this.sub = this.route.params.subscribe((params) => {
      console.log(params);
      this.animalId = params['id'];
      let pets = this.petListService.getPetList();
      this.pet = pets.find((p) => p.animalId == this.animalId) || this.dummyPet;
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
