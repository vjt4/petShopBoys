import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/models/user';
import { Userlogin } from 'src/app/models/userlogin';
import { Router } from '@angular/router';
import { SignupService } from 'src/app/services/signup.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  public username:string = "";
  public password:string = "";
  public active:boolean = true;
  public first_name:string = "";
  public last_name:string = "";
  public email:string = "";
  public isAdmin:boolean = false;
  public userLogin:any = null;
  public newUser:any = null;
  hiddenToggle:boolean = true;

  constructor(private LoginService: LoginService, private SignupService: SignupService, private router: Router) {}


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

  signUp():void {
    let userCredentials:User = {

      username: this.username,
      password: this.password,
      active: this.active,
      first_name: this.first_name,
      last_name: this.last_name,
      email: this.email,
      isAdmin: this.isAdmin
    }
    
    console.log(userCredentials);
    this.SignupService.signUp(userCredentials).subscribe(
      (data:User) => {
        this.newUser = data;
        console.log(this.newUser);
      },

      () => {
        this.newUser = null;
        console.log("couldn't sign up")
        this.hiddenToggle = false;
      }
    )

  }

}
