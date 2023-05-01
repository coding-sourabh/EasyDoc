import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Consultance } from 'src/app/shared/models/Consultance';
import { Doctor } from 'src/app/shared/models/Doctor';
import { DoctorService } from '../doctor.service';
import * as fromApp from '../../auth/store/app.reducer';
import { Patient } from 'src/app/shared/models/Patient';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-doctor-card',
  templateUrl: './doctor-card.component.html',
  styleUrls: ['./doctor-card.component.css']
})
export class DoctorCardComponent implements OnInit {
  @Input() doctor: any;
  patientId = -1;

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private doctorService: DoctorService,
    private store: Store<fromApp.AppState>,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.authService.userSubject.subscribe(
      (patientUser: any) => this.patientId = patientUser.patientId
    )

  }


  onDoctorClick() {
    const consult = new Consultance(this.patientId, this.doctor.doctorId, this.getCurrentDateAndTime());

    this.doctorService.addConsultance(consult).subscribe(
      (consultId) => {
        this.router.navigate(['/chat', this.patientId, this.doctor.doctorId, consultId]);
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
