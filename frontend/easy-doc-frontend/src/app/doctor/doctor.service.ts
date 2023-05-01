import { Injectable } from '@angular/core';
import { Doctor } from '../shared/models/Doctor';
import { HttpClient } from '@angular/common/http';
import { Cons, Observable } from 'rxjs';
import { Consultance } from '../shared/models/Consultance';

@Injectable({providedIn:  'root'})
export class DoctorService {

  URL = "http://localhost:8088/api/";

  constructor(private http: HttpClient) {}

  getAllDoctors() : Observable<Doctor[]> {
     return this.http.get<Doctor[]>(this.URL + 'doctor');
  }

  getDoctorById(id: number) {
    return this.http.get<Doctor>(this.URL + 'doctor/' + id);
  }

  addConsultance(consult: Consultance) {
    return this.http.post<string>(this.URL + 'consultance', consult);
  }

  getConsultanceByPatientAndDoctorId(patientId: number, doctorId: number) {
    return this.http.get<Consultance>(this.URL + patientId + "/" + doctorId);
  }
}
