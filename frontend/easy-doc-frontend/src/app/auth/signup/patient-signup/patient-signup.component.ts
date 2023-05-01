import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../auth.service';
import { Store } from '@ngrx/store';
import * as fromApp from '../../store/app.reducer';
import * as AuthActions from '../../store/auth.actions';
import { Patient } from 'src/app/shared/models/Patient';

@Component({
  selector: 'app-patient-signup',
  templateUrl: './patient-signup.component.html',
  styleUrls: ['./patient-signup.component.css']
})
export class PatientSignupComponent {
  patientForm = this.fb.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(4)]],
    height: ['', Validators.required],
    weight: ['', Validators.required],
    age: ['', Validators.required],
    profileImg: ['', Validators.required],
  })

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router,
    private store: Store<fromApp.AppState>
  ) { }

  onSubmit() {
    this.authService.signup('patient', this.patientForm.value).subscribe(
      (resp) => {
        this.router.navigate(['/home']);
      }
    )
  }
}
