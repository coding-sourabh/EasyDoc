import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Doctor } from '../shared/models/Doctor';
import { Patient } from '../shared/models/Patient';
// import { Doctor } from '../shared/models/Doctor';
// import { Patient } from '../shared/models/Patient';
import { AuthService } from './auth.service';
import * as fromApp from './store/app.reducer';
import * as AuthActions from './store/auth.actions';

@Component({
  selector: 'app-auth',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class AuthComponent {
  loginForm = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(4)]],
    userType: ['patient', Validators.required]
  });

  errorMessage = null;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private store: Store<fromApp.AppState>
  ) { }

  onSubmit() {
    const userType = this.loginForm.value.userType;
    const email = this.loginForm.value.email;
    const password = this.loginForm.value.password;
    this.authService.login(userType, email, password).subscribe(
      (userData: any) => {
        this.router.navigate(['/home']);
      }
    );
  }
}
