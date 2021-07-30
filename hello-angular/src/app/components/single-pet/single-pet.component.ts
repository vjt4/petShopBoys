import { Component, Input, OnInit } from '@angular/core';
import { AllPetsComponent } from '../all-pets/all-pets.component';

//aps.petArray;

@Component({
  selector: 'app-single-pet',
  templateUrl: './single-pet.component.html',
  styleUrls: ['./single-pet.component.css']
})
export class SinglePetComponent implements OnInit {
  
  //let pets: Array<any> = AllPetsComponent.petArray;
  
  //@Input() data: any[];

  constructor(private aps: AllPetsComponent) { }

  ngOnInit(): void {
  }

}
