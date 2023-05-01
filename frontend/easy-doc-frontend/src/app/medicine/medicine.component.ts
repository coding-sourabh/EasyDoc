import { Component, OnInit } from '@angular/core';
import { Medicine } from '../shared/models/Medicine';
import { MedicineService } from './medicine.service';

@Component({
  selector: 'app-medicine',
  templateUrl: './medicine.component.html',
  styleUrls: ['./medicine.component.css']
})
export class MedicineComponent implements OnInit {
  medicines: Medicine[] = [];

  constructor(private medicineService: MedicineService) { }

  ngOnInit() {
    this.medicineService.getAllMedicines().subscribe(
      (medicineData) => {
        this.medicines = medicineData;
      }
    )
  }
}
