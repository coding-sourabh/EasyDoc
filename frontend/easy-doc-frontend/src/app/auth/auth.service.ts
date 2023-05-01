import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Doctor } from "../shared/models/Doctor";
import { Patient } from "../shared/models/Patient";
import { BehaviorSubject, catchError, map, tap } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthService {
  constructor(private http: HttpClient, private router: Router) { }

  userSubject = new BehaviorSubject<Patient | Doctor | null>(null);

  URL = 'http://localhost:8088/api/'
  errorMessage: any = null;

  signup(type: string, postData: any) {
    let idToBeAdded = 'patientId';
    if (type === 'doctor')
      idToBeAdded = 'doctorId';
    return this.http.post(this.URL + type, postData)
      .pipe(
        tap((resp: any) => this.handleAuthentication({ ...postData, [idToBeAdded]: resp }))
        ,
        catchError((error: HttpErrorResponse) => this.handleError(error))
      )
  }

  login(userType: any, email: any, password: any) {
    return this.http.get<Patient | Doctor>(this.URL + userType + '/' + email + '/' + password)
      .pipe(
        tap((resp: any) => this.handleAuthentication(resp)),
        catchError((error: HttpErrorResponse) => this.handleError(error))
      )

  }

  logout() {
    this.userSubject.next(null);
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }

  autoLogin() {
    let user = JSON.parse(localStorage.getItem('user') || '{}');
    if (!user.patientId && !user.doctorId) {
      user = null;
    }
    this.userSubject.next(user);
    this.router.navigate(['/home']);
  }

  handleAuthentication(userData: Patient | Doctor) {
    localStorage.setItem('user', JSON.stringify(userData));
    this.userSubject.next(userData);
  }

  handleError(error: HttpErrorResponse) {
    return "";
  }
}
