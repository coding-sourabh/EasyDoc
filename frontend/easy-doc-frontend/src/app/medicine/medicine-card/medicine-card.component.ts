import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AllocMedicine } from 'src/app/shared/models/AllocMedcine';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'app-medicine-card',
  templateUrl: './medicine-card.component.html',
  styleUrls: ['./medicine-card.component.css']
})
export class MedicineCardComponent implements OnInit {
  @Input() medicine: any;
  doctorId: number = -1;
  patientId: number = -1;
  consultId: number = -1;

  constructor(private medicineService: MedicineService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(
      (params) => {
        this.doctorId = params['doctorId'];
        this.patientId = params['patientId'];
        this.consultId = params['consultId'];
      }
    )
  }

  onMedicineClick() {
    const allocMedicine = new AllocMedicine(this.patientId, this.medicine.medicineId, this.consultId);
    this.medicineService.allocateMedicine(allocMedicine);
  }

}
