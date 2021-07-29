import { Component, Input, OnInit } from '@angular/core';
import { AllPetsComponent } from '../all-pets/all-pets.component';
import { Pet } from 'src/app/Models/pet';

@Component({
  selector: 'app-single-pet',
  templateUrl: './single-pet.component.html',
  styleUrls: ['./single-pet.component.css'],
})
export class SinglePetComponent implements OnInit {
  constructor() {}
  @Input() pet!: Pet;

  ngOnInit(): void {}
}
