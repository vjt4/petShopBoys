import { Component, OnInit } from '@angular/core';
import { LogoutService } from 'src/app/services/logout.service';
import { Userlogout } from 'src/app/models/userlogout';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public username:string = "";
  public loggedOut:any = null;
  hiddenToggle:boolean = true;
  public loggedIn:boolean = true;

  constructor(private LogoutService: LogoutService, private router: Router) { }

  ngOnInit(): void {
  }

  logout():void {
    
    let userCredentials:Userlogout = {

      username: this.username

    }
    
    console.log(userCredentials);
    this.LogoutService.logout(userCredentials).subscribe(
      (data:Userlogout) => {
        this.loggedOut = data;
        this.loggedIn = false;
        this.hiddenToggle = false;
        console.log(this.loggedOut);
      },

      () => {
        this.loggedOut = null;
        console.log("couldn't logout")
      }
    )

  }

}
