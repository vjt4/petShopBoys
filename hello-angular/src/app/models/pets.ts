import { Binary } from "@angular/compiler";

export class Pets {
    constructor(
        public animalId:number,
        public name:string,
        public species:string,
        public breed:string,
        public age:string,
        public gender:string,
        public size:string,
        public price:number,
        public picture:string,
    ){}
}