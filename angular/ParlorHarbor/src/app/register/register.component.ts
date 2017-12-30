import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User, Role } from '../types/user.type';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username = "";
  email = "";
  fname = "";
  lname = "";
  password = "";
  confirmPassword = "";
  userRole = "User";

  usernameMessage = "";
  passwordMessage = "";
  emailMessage = "";

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.loginService.loginSubject.subscribe(u => {
      if (u != null) {
        this.router.navigate(["home"]);
      }
    });
  }

  usernameBlur() {
    this.loginService.usernameAvailable(this.username).subscribe(b => {
      this.usernameMessage = b ? "" : "That username is already taken";
    });
  }

  emailBlur() {
    this.loginService.emailAvailable(this.email).subscribe(b => {
      this.emailMessage = b ? "" : "That email is already in use";
    });
  }

  passwordBlur() {

    if (!this.passwordValid()) {
      this.passwordMessage = "Your password must be at least 8 characters long"
        + " and contain at leat 1 upper case, 1 lower case, and 1 number";
    } else if (this.password != this.confirmPassword && this.confirmPassword) {
      this.passwordMessage = "Your passwords do not match";
    } else this.passwordMessage = "";
  }

  passwordValid(): boolean {
    // this is commented out for testing purposes so we can use bad passwords
    // var passwordRegex = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/
    // if (passwordRegex.test(this.password)) return true;
    // return false;
    return true;
  }

  register() {
    var u = new User({
      username: this.username, email: this.email,
      password: this.password, fname: this.fname, lname: this.lname,
      role: this.userRole == "User" ? Role.user() : Role.barber()
    });
    if (!(this.passwordMessage || this.usernameMessage || this.emailMessage)) this.loginService.addUser(u);
  }

}
