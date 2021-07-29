import { Component, Input, OnInit } from '@angular/core';
import { PetsService } from 'src/app/services/pets.service';

@Component({
  selector: 'app-all-pets',
  templateUrl: './all-pets.component.html',
  styleUrls: ['./all-pets.component.css']
})
export class AllPetsComponent implements OnInit {

  pet1 = {
    id: 1,
    name:"Rex",
    species: "dog",
    breed:"Golden Retriever",
    age:"young",
    size:"large",
    img: "https://ewscripps.brightspotcdn.com/dims4/default/5b1b324/2147483647/strip/true/crop/2218x1248+0+85/resize/1280x720!/quality/90/?url=https:%2F%2Fewscripps.brightspotcdn.com%2F40%2Fe3%2F160ee9db4358815e56073352b7b6%2Fdcm-dog-diets-2.png"
  }

  pet2 = {
    id: 2,
    name:"Goldie",
    species: "fish",
    breed:"Goldfish",
    age:"young",
    size:"small",
    img: "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Katri.jpg/440px-Katri.jpg"
  }

  pet3 = {
    id: 3,
    name:"Callie",
    species: "cat",
    breed:"Calico",
    age:"old",
    size:"small",
    img: "https://www.thesprucepets.com/thmb/LT1TK3rcLHo15M66c7kIH8lIm44=/2782x1855/filters:fill(auto,1)/calico-cats-profile-554694-hero-c7ba9806ce1f4fb1b4d4edc2fd820a0d.jpg"
  }

  petArray = [this.pet1, this.pet2, this.pet3]

  constructor(private petsService :PetsService) { }

  ngOnInit(): void {

    //this.petArray;

    this.petArray = [this.pet1, this.pet2, this.pet3]

  }

}
