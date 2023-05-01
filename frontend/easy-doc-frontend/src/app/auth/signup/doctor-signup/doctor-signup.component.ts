import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../auth.service';

@Component({
  selector: 'app-doctor-signup',
  templateUrl: './doctor-signup.component.html',
  styleUrls: ['./doctor-signup.component.css']
})
export class DoctorSignupComponent {
  doctorForm = this.fb.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(4)]],
    specialist: ['', Validators.required],
    fees: ['', Validators.required],
    experience: ['', Validators.required],
    profileImg: ['', Validators.required],
  })

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) { }

  onSubmit() {
    this.authService.signup('doctor', this.doctorForm.value).subscribe(
      (resp) => {
        this.router.navigate(['/home']);
      }
    )
  }
}
