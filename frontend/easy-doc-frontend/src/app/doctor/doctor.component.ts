import { Component, OnInit } from '@angular/core';
import { Doctor } from '../shared/models/Doctor';
import { DoctorService } from './doctor.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  doctors: Doctor[] = [];
  constructor(private doctorService: DoctorService) {}

  ngOnInit(): void {
    this.doctorService.getAllDoctors().subscribe(
      (docs : Doctor[]) => {
        this.doctors = docs;
      }
    )
  }

}
