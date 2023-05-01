import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AllocExcercise } from "../shared/models/AllocExcercise";
import { Excercise } from "../shared/models/Excercise";

@Injectable({providedIn: 'root'})
export class ExcerciseService {
  constructor(private http: HttpClient) {}

  URL = "http://localhost:8088/api/";

  getAllExcercises() {
    return this.http.get<Excercise[]>(this.URL + 'excercise');
  }

  allocateExcercise(allocExc: AllocExcercise) {
    this.http.post(this.URL + 'excercise/alloc', allocExc).subscribe(
      (resp) => {}
    )
  }

  getAllConsultedExcercises(patientId: number, consultId: number) {
    return this.http.get<Excercise[]>(this.URL + 'excercise/alloc/' + patientId + '/' + consultId);
  }

  removeConsultedExcercise(patientId: number, consultId: number, exId: number) {
    return this.http.delete(this.URL + 'excercise/remove/' + patientId + "/" + consultId + "/" + exId);
  }
}
