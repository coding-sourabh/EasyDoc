import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AllocFood } from 'src/app/shared/models/AllocFood';
import { Food } from 'src/app/shared/models/Food';
import { FoodService } from '../food.service';

@Component({
  selector: 'app-food-card',
  templateUrl: './food-card.component.html',
  styleUrls: ['./food-card.component.css']
})
export class FoodCardComponent {
  @Input() food: any;
  doctorId: number = -1;
  patientId: number = -1;
  consultId: number = -1;

  constructor(private foodService: FoodService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(
      (params) => {
        this.doctorId = params['doctorId'];
        this.patientId = params['patientId'];
        this.consultId = params['consultId'];
      }
    )
  }

  onFoodClick() {
    const allocFood = new AllocFood(this.patientId, this.food.foodId, this.consultId);
    this.foodService.allocateFood(allocFood);
  }
}
