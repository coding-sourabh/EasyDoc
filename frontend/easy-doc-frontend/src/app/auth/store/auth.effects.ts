import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Actions } from '@ngrx/effects';
import { createEffect, ofType } from '@ngrx/effects';
import { catchError, map, of, pipe, switchMap, tap } from 'rxjs';
import { Patient } from 'src/app/shared/models/Patient';
import { AuthService } from '../auth.service';

import * as AuthActions from './auth.actions';

@Injectable()
export class AuthEffects {
  constructor(
    private actions$: Actions,
    private http: HttpClient,
    private authService: AuthService
  ) { }

  URL = 'http://localhost:8088/api/';

  handleAuthentication(resData: any) {
    if (resData.patientId) {
      localStorage.setItem('patientUser', JSON.stringify(resData));
      return new AuthActions.PatientLogin(resData);
    } else {
      localStorage.setItem('doctorUser', JSON.stringify(resData));
      return new AuthActions.DoctorLogin(resData);
    }
  }

  handleError(errorResp: HttpErrorResponse) {
    let errorMessage = 'An unknown error occurred';
    if (!errorResp.error || !errorResp.error.error) {
      return of(new AuthActions.AuthenticateFail(errorMessage));
    }

    return of(new AuthActions.AuthenticateFail(errorMessage));  // because catch error does not automatically wrap observable like map do, so have to create a observable by using 'of' operator
  }

  authSignup = createEffect(
    () => this.actions$.pipe(
      ofType(AuthActions.PATIENT_SIGNUP_START),

      switchMap((patientSignupAction: AuthActions.PatientSignupStart) => {
        return this.http
          .post('http://localhost:8088/api/' + 'patient', patientSignupAction.payload)
          .pipe(
            map(this.handleAuthentication),
            catchError(this.handleError)
          )
      })
    )
  )
}
