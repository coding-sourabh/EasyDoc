import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import { PatientComponent } from './patient/patient.component';
import { DoctorComponent } from './doctor/doctor.component';
import { HttpClientModule } from '@angular/common/http';
import { DoctorCardComponent } from './doctor/doctor-card/doctor-card.component';
import { ChatComponent } from './chat/chat.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ExcerciseComponent } from './excercise/excercise.component';
import { FoodComponent } from './food/food.component';
import { MedicineComponent } from './medicine/medicine.component';
import { ExcerciseCardComponent } from './excercise/excercise-card/excercise-card.component';
import { FoodCardComponent } from './food/food-card/food-card.component';
import { MedicineCardComponent } from './medicine/medicine-card/medicine-card.component';
import { ViewBasketComponent } from './view-basket/view-basket.component';
import { BasketComponent } from './basket/basket.component';
import { ViewExcerciseBasketComponent } from './view-basket/view-excercise-basket/view-excercise-basket.component';
import { ViewFoodBasketComponent } from './view-basket/view-food-basket/view-food-basket.component';
import { ViewMedicineBasketComponent } from './view-basket/view-medicine-basket/view-medicine-basket.component';
import { AuthComponent } from './auth/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { PatientSignupComponent } from './auth/signup/patient-signup/patient-signup.component';
import { DoctorSignupComponent } from './auth/signup/doctor-signup/doctor-signup.component';
import { StoreModule } from '@ngrx/store';
import { appReducer } from './auth/store/app.reducer';
import { EffectsModule } from '@ngrx/effects';
import { AuthEffects } from './auth/store/auth.effects';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    PatientComponent,
    DoctorComponent,
    DoctorCardComponent,
    ChatComponent,
    ExcerciseComponent,
    FoodComponent,
    MedicineComponent,
    ExcerciseCardComponent,
    FoodCardComponent,
    MedicineCardComponent,
    ViewBasketComponent,
    BasketComponent,
    ViewExcerciseBasketComponent,
    ViewFoodBasketComponent,
    ViewMedicineBasketComponent,
    AuthComponent,
    SignupComponent,
    PatientSignupComponent,
    DoctorSignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    StoreModule.forRoot(appReducer),
    EffectsModule.forRoot([AuthEffects])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
