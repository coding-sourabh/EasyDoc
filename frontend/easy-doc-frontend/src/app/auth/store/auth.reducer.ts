import { Patient } from 'src/app/shared/models/Patient';
import { Doctor } from 'src/app/shared/models/Doctor';
import * as AuthActions from './auth.actions';

export interface AuthState {
  user: Patient | Doctor | null,
  authError: string | null,
  loading: boolean
}

const initialState: AuthState = {
  user: null,
  authError: null,
  loading: false
}

export function authReducer(state = initialState, action: AuthActions.AuthActions): AuthState {
  switch (action.type) {
    case AuthActions.PATIENT_LOGIN:
      const patient = new Patient(
        action.payload.patientId,
        action.payload.name,
        action.payload.email,
        action.payload.password,
        action.payload.height,
        action.payload.weight,
        action.payload.age,
        action.payload.profileImg
      )

      return {
        ...state,
        user: patient,
        authError: null,
        loading: false
      }

    case AuthActions.PATIENT_SIGNUP_START:
      return {
        ...state,
        authError: null,
        loading: true
      }

    case AuthActions.PATIENT_AUTHENTICATE_START:
      return {
        ...state,
        authError: null,
        loading: true
      }

    case AuthActions.DOCTOR_LOGIN:
      const doctor = new Doctor(
        action.payload.doctorId,
        action.payload.name,
        action.payload.email,
        action.payload.password,
        action.payload.specialist,
        action.payload.fees,
        action.payload.experience,
        action.payload.profileImg
      );

      return {
        ...state,
        user: doctor,
        authError: null,
        loading: false
      }

    case AuthActions.AUTHENTICATE_FAIL:
      return {
        ...state,
        user: null,
        authError: action.payload,
        loading: false
      }

    default:
      return state;
  }
}
