import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DoctorService } from '../doctor/doctor.service';
import { ExcerciseService } from '../excercise/excercise.service';
import { FoodService } from '../food/food.service';
import { MedicineService } from '../medicine/medicine.service';
import { Excercise } from '../shared/models/Excercise';
import { Food } from '../shared/models/Food';
import { Medicine } from '../shared/models/Medicine';
import { Patient } from '../shared/models/Patient';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit {
  chatDoctorId: number = -1;
  chatPatientId: number = 1;
  consultId: number = -1;
  chatDoctor: any;
  chatPatient: any;
  allocExcLen: number = 0;
  allocFoodLen: number = 0;
  allocMedLen: number = 0;

  constructor(
    private excerciseService: ExcerciseService,
    private foodService: FoodService,
    private medicineService: MedicineService,
    private doctorService: DoctorService,
    private activatedRoute: ActivatedRoute,

  ) { }

  ngOnInit() {

    this.activatedRoute.params.subscribe(
      (params) => {
        this.chatPatientId = params['patientId']
        this.chatDoctorId = params['doctorId'];
        this.consultId = params['consultId'];
        this.handleComponents();
      })


  }

  handleComponents() {
    this.doctorService.getDoctorById(this.chatDoctorId).subscribe(
      (doctor) => {
        this.chatDoctor = doctor;
      }
    )

    this.excerciseService.getAllConsultedExcercises(this.chatPatientId, this.consultId).subscribe(
      (consultedExcercises: Excercise[]) => {
        this.allocExcLen = consultedExcercises.length
      }
    )

    this.foodService.getAllConsultedFoods(this.chatPatientId, this.consultId).subscribe(
      (consultedFoods: Food[]) => {
        this.allocFoodLen = consultedFoods.length
      }
    )

    this.medicineService.getAllConsultedMedicines(this.chatPatientId, this.consultId).subscribe(
      (consultedMedicines: Medicine[]) => {
        this.allocMedLen = consultedMedicines.length
      }
    )
  }
}
