import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/models/user';
import { Userlogin } from 'src/app/models/userlogin';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  public username:string = "";
  public password:string = "";
  public userLogin:any = null;

  constructor(private LoginService: LoginService) {}


  ngOnInit(): void {}

  login():void {
      let userCredentials:Userlogin = {

        username: this.username,
        password: this.password

      }

      this.LoginService.loginUser(userCredentials).subscribe(
        (data:Userlogin) => {
          this.userLogin = data;
          console.log(this.userLogin);
        },

        () => {
          this.userLogin = null;
          console.log("couldn't login")
        }
      )

  }

}
