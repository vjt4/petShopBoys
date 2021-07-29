import { Component, OnInit } from '@angular/core';
import { PETS } from 'src/app/Models/pet';

@Component({
  selector: 'app-all-pets',
  templateUrl: './all-pets.component.html',
  styleUrls: ['./all-pets.component.css'],
})
export class AllPetsComponent implements OnInit {
  pets = PETS;

  constructor() {}

  ngOnInit(): void {}
}
