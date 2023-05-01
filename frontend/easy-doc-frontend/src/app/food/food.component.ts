import { Component, OnInit } from '@angular/core';
import { Food } from '../shared/models/Food';
import { FoodService } from './food.service';

@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.css']
})
export class FoodComponent implements OnInit {
  foods: Food[] = [];
  constructor(private foodService: FoodService) { }

  ngOnInit(): void {
    this.foodService.getAllFood().subscribe(
      (foodData) => this.foods = foodData
    )
  }
}
