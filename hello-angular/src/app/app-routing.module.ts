import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SearchpetsComponent } from './components/searchpets/searchpets.component';

const routes: Routes = [
  
  {
    path:'login',
    component:LoginComponent
  },
  
  {
    path:'', 
    component:LoginComponent
  },
  
  {
    path:'searchpets',
    component:SearchpetsComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
