import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ExcerciseService } from 'src/app/excercise/excercise.service';
import { Excercise } from 'src/app/shared/models/Excercise';

@Component({
  selector: 'app-view-excercise-basket',
  templateUrl: './view-excercise-basket.component.html',
  styleUrls: ['./view-excercise-basket.component.css']
})

export class ViewExcerciseBasketComponent implements OnInit {
  allocExcercise: any[] = [];
  patientId: number = -1;
  consultId: number = -1;

  constructor(private activatedRoute: ActivatedRoute, private excerciseService: ExcerciseService) { }

  ngOnInit(): void {
    this.activatedRoute?.parent?.params.subscribe(
      (params) => {
        this.patientId = params['patientId'];
        this.consultId = params['consultId'];
        this.excerciseService.getAllConsultedExcercises(params['patientId'], params['consultId']).subscribe(
          (excData) => this.allocExcercise = excData
        )
      }
    )
  }

  onRemoveClick(exId: number) {
    this.excerciseService.removeConsultedExcercise(this.patientId, this.consultId, exId).subscribe(
      () => {
        this.excerciseService.getAllConsultedExcercises(this.patientId, this.consultId).subscribe(
          (exData) => { this.allocExcercise = exData }
        )
      }
    )
  }
}
