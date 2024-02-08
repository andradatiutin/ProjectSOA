import {Component, OnInit} from '@angular/core';

import {Router} from "@angular/router";
import {User} from "../shared/user.model";
import {UserService} from "../shared/user.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  users: User[] = [];
  invalid = false;

  constructor(private service: UserService, private router: Router) {
  }

  ngOnInit(): void {
    this.service.getLoginUsers().subscribe(users => this.users = users);
    console.log(this.users);
  }


  // @ts-ignore
  login(form): void {
    this.ngOnInit();

    let i;
    for (i = 0; i < this.users.length; i++) {
      if (this.users[i].username == form.value.username && this.users[i].password == form.value.password) {
        localStorage.setItem("username", String(this.users[i].username));
        this.router.navigate(["products"]);
        this.invalid = false;
        return;
      }
    }
    this.invalid = true;
  }
}
