import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MedicineService } from 'src/app/medicine/medicine.service';
import { Medicine } from 'src/app/shared/models/Medicine';

@Component({
  selector: 'app-view-medicine-basket',
  templateUrl: './view-medicine-basket.component.html',
  styleUrls: ['./view-medicine-basket.component.css']
})
export class ViewMedicineBasketComponent {
  allocMedicine: any[] = [];
  patienId: number = -1;
  consultId: number = -1;

  constructor(private activatedRoute: ActivatedRoute, private medicineService: MedicineService) { }


  ngOnInit(): void {
    this.activatedRoute?.parent?.params.subscribe(
      (params) => {
        this.patienId = params['patientId'];
        this.consultId = params['consultId'];
        this.medicineService.getAllConsultedMedicines(params['patientId'], params['consultId']).subscribe(
          (medData) => this.allocMedicine = medData
        )
      }
    )
  }

  onRemoveClick(medicineId: number) {
    this.medicineService.removeConsultedExcercise(this.patienId, this.consultId, medicineId).subscribe(
      () => {
        this.medicineService.getAllConsultedMedicines(this.patienId, this.consultId).subscribe(
          (medData) => this.allocMedicine = medData
        )
      }
    )
  }
}

