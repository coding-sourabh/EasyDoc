import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AllocFood } from "../shared/models/AllocFood";
import { Food } from "../shared/models/Food";

@Injectable({providedIn: "root"})
export class FoodService {
  constructor(private http: HttpClient) {}

  URL = "http://localhost:8088/api/";

  getAllFood() {
    return this.http.get<Food[]>(this.URL + 'food');
  }

  allocateFood(allocExc: AllocFood) {
    this.http.post(this.URL + 'food/alloc', allocExc).subscribe(
      (resp) => {}
    )
  }

  getAllConsultedFoods(patientId: number, consultId: number) {
    return this.http.get<Food[]>(this.URL + 'food/alloc/' + patientId + '/' + consultId);
  }

  removeConsultedFood(patientId: number, consultId: number, foodId: number) {
    return this.http.delete(this.URL + 'food/remove/' + patientId + "/" + consultId + "/" + foodId);
  }
}
