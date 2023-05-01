import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'easy-doc-frontend';
  userPresent: any = null;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.autoLogin();
    this.authService.userSubject.subscribe(
      ((user: any) => this.userPresent = user)
    )
  }
}

