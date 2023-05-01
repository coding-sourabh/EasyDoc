import { Component, OnInit } from '@angular/core';
import { map, take } from 'rxjs';
import { AppService } from '../app.service';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loggedIn: string = "";

  constructor(private appService: AppService, private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.userSubject.pipe(
      take(1),
      map((user: any) => {
        if (user.patientId) {
          this.loggedIn = 'patient';
        } else {
          this.loggedIn = 'doctor';
        }
      })
    ).subscribe();
  }

  onLogoutClick() {
    this.authService.logout();
  }
}
