import { ActionReducerMap } from '@ngrx/store';
import * as fromAuth from './auth.reducer';

export interface AppState {
  auth: fromAuth.AuthState;
}

// one place to manage all reducers for each slice of AppState, i.e merged reducer map
export const appReducer: ActionReducerMap<AppState, any> = {
  auth: fromAuth.authReducer
};
