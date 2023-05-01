import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PatientComponent } from './patient/patient.component';
import { DoctorComponent } from './doctor/doctor.component';
import { ChatComponent } from './chat/chat.component';
import { ExcerciseComponent } from './excercise/excercise.component';
import { FoodComponent } from './food/food.component';
import { MedicineComponent } from './medicine/medicine.component';
import { ViewBasketComponent } from './view-basket/view-basket.component';
import { ViewExcerciseBasketComponent } from './view-basket/view-excercise-basket/view-excercise-basket.component';
import { ViewFoodBasketComponent } from './view-basket/view-food-basket/view-food-basket.component';
import { ViewMedicineBasketComponent } from './view-basket/view-medicine-basket/view-medicine-basket.component';
import { AuthComponent } from './auth/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { PatientSignupComponent } from './auth/signup/patient-signup/patient-signup.component';
import { DoctorSignupComponent } from './auth/signup/doctor-signup/doctor-signup.component';
import { AuthGuard } from './auth/auth.guard';


const routes: Routes = [
  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: AuthComponent},
  {
    path: 'signup', component: SignupComponent,
    children: [
      { path: 'patient', component: PatientSignupComponent },
      { path: 'doctor', component: DoctorSignupComponent }
    ]
  },
  { path: 'patients', component: PatientComponent },
  { path: 'doctors', component: DoctorComponent },
  { path: 'chat/:patientId/:doctorId/:consultId', component: ChatComponent },
  { path: 'excercise/:patientId/:doctorId/:consultId', component: ExcerciseComponent },
  { path: 'food/:patientId/:doctorId/:consultId', component: FoodComponent },
  { path: 'medicine/:patientId/:doctorId/:consultId', component: MedicineComponent },
  {
    path: 'viewBasket/:patientId/:doctorId/:consultId/:bt', component: ViewBasketComponent,
    children: [
      { path: 'excercise', component: ViewExcerciseBasketComponent },
      { path: 'food', component: ViewFoodBasketComponent },
      { path: 'medicine', component: ViewMedicineBasketComponent },
    ]

  },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home' }
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
