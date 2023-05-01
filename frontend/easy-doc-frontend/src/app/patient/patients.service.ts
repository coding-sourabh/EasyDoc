import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Patient } from '../shared/models/Patient';

@Injectable({ providedIn: 'root' })
export class PatientService {

  URL = "http://localhost:8088/api/";

  constructor(private http: HttpClient) {}

  getPatients() {
    return this.http.get(this.URL + 'patient');
  }

  getPatientById(patientId: number) {
    return this.http.get<Patient>(this.URL + 'patient/' + patientId);
  }
}
