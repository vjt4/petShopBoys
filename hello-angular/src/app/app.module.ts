import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { NavbarComponent } from './components/navbar/navbar.component';

import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { SharedBootstrapModule } from './shared/shared-bootstrap.module';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { SinglePetComponent } from './components/single-pet/single-pet.component';
import { AllPetsComponent } from './components/all-pets/all-pets.component';
import { CartComponent } from './components/cart/cart.component';
import { PetsComponent } from './components/pets/pets.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SinglePetComponent,
    NavbarComponent,
    AllPetsComponent,
    CartComponent,
    PetsComponent,
    //declare components here
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    RouterModule,
    AppRoutingModule,
    SharedBootstrapModule,
    BrowserAnimationsModule,
    HttpClientModule,
  ],
  exports: [],
  providers: [AllPetsComponent],
  bootstrap: [AppComponent],
})
export class AppModule {}
