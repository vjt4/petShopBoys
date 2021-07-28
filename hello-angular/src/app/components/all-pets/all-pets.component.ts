import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-pets',
  templateUrl: './all-pets.component.html',
  styleUrls: ['./all-pets.component.css']
})
export class AllPetsComponent implements OnInit {

  pet1 = {
    id: 1,
    content: "dog",
    img: "https://ewscripps.brightspotcdn.com/dims4/default/5b1b324/2147483647/strip/true/crop/2218x1248+0+85/resize/1280x720!/quality/90/?url=https:%2F%2Fewscripps.brightspotcdn.com%2F40%2Fe3%2F160ee9db4358815e56073352b7b6%2Fdcm-dog-diets-2.png"
  }

  pet2 = {
    id: 2,
    content: "cat",
    img: "https://ewscripps.brightspotcdn.com/dims4/default/5b1b324/2147483647/strip/true/crop/2218x1248+0+85/resize/1280x720!/quality/90/?url=https:%2F%2Fewscripps.brightspotcdn.com%2F40%2Fe3%2F160ee9db4358815e56073352b7b6%2Fdcm-dog-diets-2.png"
  }

  pet3 = {
    id: 3,
    content: "fish",
    img: "https://ewscripps.brightspotcdn.com/dims4/default/5b1b324/2147483647/strip/true/crop/2218x1248+0+85/resize/1280x720!/quality/90/?url=https:%2F%2Fewscripps.brightspotcdn.com%2F40%2Fe3%2F160ee9db4358815e56073352b7b6%2Fdcm-dog-diets-2.png"
  }

  petArray = [this.pet1, this.pet2, this.pet3]

  constructor() { }

  ngOnInit(): void {
  }

}
