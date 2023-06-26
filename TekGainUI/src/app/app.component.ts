import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'TekGain';
  flag = false;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    // Add initialization code here
    // Example: You can subscribe to the logstatus event in the AuthService
    // to update the flag based on the login status
    this.authService.logstatus.subscribe((status: string) => {
      this.flag = status === 'loggedIn';
    });
  }
}
