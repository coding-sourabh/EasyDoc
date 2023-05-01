import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { DoctorService } from '../doctor/doctor.service';
import { Patient } from '../shared/models/Patient';
import { HomeService } from './home.service';
import { map, switchMap, take } from 'rxjs';
import { Doctor } from '../shared/models/Doctor';
import { Consultance } from '../shared/models/Consultance';

class Consult {
  constructor(private doctor: Doctor, private timeStamp: string, private consultId: number) { }
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  patient: any;
  myConsultance: any[] = [];


  constructor(
    private homeService: HomeService,
    private router: Router,
    private doctorService: DoctorService,
    private authService: AuthService
  ) { }

  ngOnInit() {

    this.authService.userSubject.pipe(
      take(1),
      switchMap((userPat: any) => {
        this.patient = userPat;
        return this.homeService.getConsultants(userPat.patientId) // this will return new observable discarding previous one
      })
    )
      .subscribe(
        (consultArr: any) => {
          consultArr.forEach((consult: any) => {
            this.doctorService.getDoctorById(consult.doctorId).subscribe(
              (doc) => this.myConsultance.push(new Consult(doc, consult.dateTime, consult.consultId))
            )
          });
        }
      )
  }

  onViewButton(doctorId: number, consultId: number) {
    this.router.navigate(['/chat', this.patient.patientId, doctorId, consultId]);
  }
}
