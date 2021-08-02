import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AllPetsComponent } from '../all-pets/all-pets.component';
import { PetsInterface } from 'src/app/models/petsInterface';
import { SinglePetService } from '../../services/single-pet.service';
import { singlePet } from 'src/app/models/singlePet';

@Component({
  selector: 'app-single-pet',
  templateUrl: './single-pet.component.html',
  styleUrls: ['./single-pet.component.css'],
})
export class SinglePetComponent implements OnInit {
  public animalId: number = 0;
  public id: any = null;

  //@Input() data: any[];

  constructor(
    private route: ActivatedRoute,
    private SinglePetService: SinglePetService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  getPet(): void {
    let pet: singlePet = {
      animalId: this.animalId,
    };
    this.SinglePetService.getPet(pet).subscribe(
      (data: singlePet) => {
        this.id = data;
      },
      () => {
        this.animalId = 1;
      }
    );
  }
}
