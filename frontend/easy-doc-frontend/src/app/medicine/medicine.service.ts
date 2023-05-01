import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AllocMedicine } from "../shared/models/AllocMedcine";
import { Medicine } from "../shared/models/Medicine";

@Injectable({ providedIn: 'root' })
export class MedicineService {
  constructor(private http: HttpClient) { }

  URL = "http://localhost:8088/api/";

  getAllMedicines() {
    return this.http.get<Medicine[]>(this.URL + 'medicine');
  }

  allocateMedicine(allocExc: AllocMedicine) {
    this.http.post(this.URL + 'medicine/alloc', allocExc).subscribe(
      (resp) => {}
    )
  }

  getAllConsultedMedicines(patientId: number, consultId: number) {
    return this.http.get<Medicine[]>(this.URL + 'medicine/alloc/' + patientId + '/' + consultId);
  }

  removeConsultedExcercise(patientId: number, consultId: number, medicineId: number) {
    return this.http.delete(this.URL + 'medicine/remove/' + patientId + "/" + consultId + "/" + medicineId);
  }
}
