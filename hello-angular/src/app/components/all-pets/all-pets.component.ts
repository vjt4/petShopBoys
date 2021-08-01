import { Component, Input, OnInit } from '@angular/core';
import { PetsService } from 'src/app/services/pets.service';
import { Pets } from 'src/app/models/pets';

@Component({
  selector: 'app-all-pets',
  templateUrl: './all-pets.component.html',
  styleUrls: ['./all-pets.component.css'],
})
export class AllPetsComponent implements OnInit {

  public pet:any = null;

  constructor(private petsService :PetsService) { }

  ngOnInit(): void {
    this.getPets();
}

  

  getPets():void {

    this.petsService.getPets(this.pet).subscribe(
      (data:Pets) => {
        this.pet = data
        console.log(this.pet)
      },
      () => {
        this.pet = null
        console.log("couldn't get pets")
      }
    )
  }

}