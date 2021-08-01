import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/models/user';
import { Userlogin } from 'src/app/models/userlogin';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  public username:string = "";
  public password:string = "";
  public userLogin:any = null;
  hiddenToggle:boolean = true;

  constructor(private LoginService: LoginService, private router: Router) {}


  ngOnInit(): void {}

  login():void {
      let userCredentials:Userlogin = {

        username: this.username,
        password: this.password

      }
      console.log(userCredentials);
      this.LoginService.loginUser(userCredentials).subscribe(
        (data:Userlogin) => {
          this.userLogin = data;
          console.log(this.userLogin);
          this.router.navigate(['pets/allpets']);
        },

        () => {
          this.userLogin = null;
          console.log("couldn't login")
          this.hiddenToggle = false;
        }
      )

  }

}
