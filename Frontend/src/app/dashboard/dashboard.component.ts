import { Component, OnInit } from '@angular/core';
import { UserStateService } from '../service/user-state.service';
import { User } from '../model/user';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  loggedInUser: User | null = null;

  constructor(private userStateService: UserStateService) {}

  ngOnInit() {
    this.userStateService.loggedInUser$.subscribe(user => {
      this.loggedInUser = user;
    });
  }

}
