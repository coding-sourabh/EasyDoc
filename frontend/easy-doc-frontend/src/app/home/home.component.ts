import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { DoctorService } from '../doctor/doctor.service';
import { Patient } from '../shared/models/Patient';
import { HomeService } from './home.service';
import { map, switchMap, take } from 'rxjs';
import { Doctor } from '../shared/models/Doctor';
import { Consultance } from '../shared/models/Consultance';
import { PatientService } from '../patient/patients.service';

class Consult {
  constructor(private doctor: Doctor, private patient: Patient, private timeStamp: string, private consultId: number) { }
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  loggedUser: any;
  myConsultance: any[] = [];


  constructor(
    private homeService: HomeService,
    private router: Router,
    private doctorService: DoctorService,
    private patientService: PatientService,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.authService.userSubject.pipe(
      take(1),
      switchMap((user: any) => {
        if(user.doctorId) {
          this.loggedUser = user;
          console.log(user);

          return this.homeService.getConsultantsByDoctorId(user.doctorId);
        } else  {
          this.loggedUser = user;
          return this.homeService.getConsultantsByPatientId(user.patientId);
        }
      })
    )
      .subscribe(
        (consultArr: any) => {
          console.log(consultArr);
          consultArr.forEach((consult: any) => {
            this.doctorService.getDoctorById(consult.doctorId).subscribe(
              (doc) => {
                this.patientService.getPatientById(consult.patientId).subscribe(
                  (pat) => {
                    this.myConsultance.push(new Consult(doc, pat, consult.dateTime, consult.consultId))
                  }
                )
              }
            )
          });
        }
      )
  }

  onViewButton(id: number, consultId: number) {
    console.log(id);

    if(this.loggedUser.patientId) {
      this.router.navigate(['/chat', this.loggedUser.patientId, id, consultId]);
    } else {
      this.router.navigate(['/chat', id, this.loggedUser.doctorId, consultId]);
    }
  }
}
