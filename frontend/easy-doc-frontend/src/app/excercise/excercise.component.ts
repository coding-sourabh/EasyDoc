import { Component, OnInit } from '@angular/core';
import { Excercise } from '../shared/models/Excercise';
import { ExcerciseService } from './excercise.service';

@Component({
  selector: 'app-excercise',
  templateUrl: './excercise.component.html',
  styleUrls: ['./excercise.component.css']
})
export class ExcerciseComponent implements OnInit {
  excercises: Excercise[] = [];

  constructor(private excerciseService: ExcerciseService) { }

  ngOnInit() {
    this.excerciseService.getAllExcercises().subscribe(
      (exceriseData) => {
        this.excercises = exceriseData;
      }
    )
  }
}

