import { Component } from '@angular/core';
import { UserService } from './service/user.service';
import { UserStateService } from './service/user-state.service';
import { User } from './model/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  loggedInUser!: User;
  title: string;

  constructor(private userService: UserService, private userStateService: UserStateService, public router: Router) {
    this.title = 'Grocery Shop';
  }
  ngOnInit() {
    this.userStateService.loggedInUser$.subscribe(user => {
      this.loggedInUser = user!;
    });
  }
  public logout(){
    this.userService.logout();
    this.router.navigate(['/login']);
  }
}