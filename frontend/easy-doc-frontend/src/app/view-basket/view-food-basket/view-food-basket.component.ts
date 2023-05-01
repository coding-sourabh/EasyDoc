import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FoodService } from 'src/app/food/food.service';
import { Food } from 'src/app/shared/models/Food';

@Component({
  selector: 'app-view-food-basket',
  templateUrl: './view-food-basket.component.html',
  styleUrls: ['./view-food-basket.component.css']
})
export class ViewFoodBasketComponent {
  allocFood: any[] = [];
  patientId: number = -1;
  consultId: number = -1;

  constructor(private activatedRoute: ActivatedRoute, private foodService: FoodService) { }


  ngOnInit(): void {
    this.activatedRoute?.parent?.params.subscribe(
      (params) => {
        this.patientId = params['patientId'];
        this.consultId = params['consultId'];
        this.foodService.getAllConsultedFoods(params['patientId'], params['consultId']).subscribe(
          (foodData) => this.allocFood = foodData
        )
      }
    )
  }

  onRemoveClick(foodId: number) {
    this.foodService.removeConsultedFood(this.patientId, this.consultId, foodId).subscribe(
      () => {
        this.foodService.getAllConsultedFoods(this.patientId, this.consultId).subscribe(
          (foodData) => this.allocFood = foodData
        )
      }
    )
  }
}
