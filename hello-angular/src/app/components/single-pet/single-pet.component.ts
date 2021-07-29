import { Component, Input, OnInit } from '@angular/core';
import { AllPetsComponent } from '../all-pets/all-pets.component';
import { Pet } from 'src/app/Models/Pet';

@Component({
  selector: 'app-single-pet',
  //templateUrl: './single-pet.component.html',
  template: `
    <h3>{{ pet.name }} says:</h3>
    <p>{{ pet.name }}</p>
  `,
})
export class SinglePetComponent implements OnInit {
  constructor() {}
  @Input() pet!: Pet;

  ngOnInit(): void {}
}
