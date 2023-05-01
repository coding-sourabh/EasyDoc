import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Excercise } from 'src/app/shared/models/Excercise';
import { AllocExcercise } from 'src/app/shared/models/AllocExcercise';
import { ExcerciseService } from '../excercise.service';

@Component({
  selector: 'app-excercise-card',
  templateUrl: './excercise-card.component.html',
  styleUrls: ['./excercise-card.component.css']
})
export class ExcerciseCardComponent implements OnInit {
  @Input() excercise: any;
  doctorId: number = -1;
  patientId: number = -1;
  consultId: number = -1;

  constructor(private acitvatedRoute: ActivatedRoute, private excerciseService: ExcerciseService) { }

  ngOnInit(): void {
    this.acitvatedRoute.params.subscribe(
      (params) => {
        this.doctorId = params['doctorId'];
        this.patientId = params['patientId'];
        this.consultId = params['consultId'];
      }
    )
  }

  onexcerciseClick() {
    const allocExc = new AllocExcercise(this.patientId, this.excercise.excerciseId, this.consultId);
    this.excerciseService.allocateExcercise(allocExc);
  }
}
