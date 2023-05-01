import { Component, OnInit } from '@angular/core';
import { PatientService } from './patients.service';
import { Patient } from '../shared/models/Patient';
import * as fromApp from '../auth/store/app.reducer';
import { Store } from '@ngrx/store';
import { Router } from '@angular/router';
import { Consultance } from '../shared/models/Consultance';
import { Doctor } from '../shared/models/Doctor';
import { DoctorService } from '../doctor/doctor.service';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {
  patients: Patient[] = [];
  doctor: any = null;

  constructor(
    private patientService: PatientService,
    private store: Store<fromApp.AppState>,
    private router: Router,
    private doctorService: DoctorService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.authService.userSubject.subscribe(
      (user) => this.doctor = user
    )

    this.patientService.getPatients().subscribe(
      (fetchedPatients: any) => {
        this.patients = fetchedPatients;
      }
    )
  }

  onChatClick(patient: Patient) {
    const consult = new Consultance(patient.patientId, this.doctor.doctorId, this.getCurrentDateAndTime());

    this.doctorService.addConsultance(consult).subscribe(
      (consultId) => {
        this.router.navigate(['/chat', patient.patientId, this.doctor.doctorId, consultId]);
      }
    )
  }

  getCurrentDateAndTime() {
    const currentdate = new Date();
    return currentdate.getDate() + "-"
      + (currentdate.getMonth() + 1) + "-"
      + currentdate.getFullYear() + " "
      + currentdate.getHours() + ":"
      + currentdate.getMinutes() + ":"
      + currentdate.getSeconds();
  }
}
