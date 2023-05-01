import { Action } from '@ngrx/store';
import { Doctor } from 'src/app/shared/models/Doctor';
import { Patient } from 'src/app/shared/models/Patient';

export const PATIENT_LOGIN = "[Auth] Patient Login";
export const DOCTOR_LOGIN = "[Auth] Doctor Login";
export const PATIENT_SIGNUP_START = "[Auth] Patient Signup Start";
export const DOCTOR_SIGNUP_START = "[Auth] Doctor Signup Start";
export const PATIENT_AUTHENTICATE_START = "[Auth] Patient Authenticate Start";
export const AUTHENTICATE_FAIL = "[Auth] Authenticate Fail";

export class PatientLogin implements Action {
  readonly type = PATIENT_LOGIN;

  constructor(public payload: Patient
  ) { }
}

export class DoctorLogin implements Action {
  readonly type = DOCTOR_LOGIN;

  constructor(public payload: Doctor
  ) { }
}

export class PatientSignupStart implements Action {
  readonly type = PATIENT_SIGNUP_START;

  constructor(public payload: Patient
  ) { }
}

export class PatientAuthenticateStart implements Action {
  readonly type = PATIENT_AUTHENTICATE_START;

  constructor(public payload: { email: string; password: string }) { }
}

// *********************************************

export class AuthenticateFail implements Action {
  readonly type = AUTHENTICATE_FAIL

  constructor(public payload: string) { }
}

export class DoctorSignupStart implements Action {
  readonly type = DOCTOR_SIGNUP_START;

  constructor(public payload: Doctor
  ) { }
}



export type AuthActions =
PatientLogin |
DoctorLogin |
PatientSignupStart |
DoctorSignupStart |
PatientAuthenticateStart |
AuthenticateFail
;
