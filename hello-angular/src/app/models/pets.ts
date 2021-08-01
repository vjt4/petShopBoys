import { Binary } from "@angular/compiler";

export class Pets {
    constructor(
        private name:string,
        private species:string,
        private breed:string,
        private age:string,
        private gender:string,
        private size:string,
        private price:number,
        private picture:string,
    ){}
}