import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root'})
export class HomeService {
  URL = 'http://localhost:8088/api/';
  constructor(private http: HttpClient) {}

  getConsultants(patientId: number) {
    return this.http.get(this.URL + 'consultance/' + patientId);
  }
}
