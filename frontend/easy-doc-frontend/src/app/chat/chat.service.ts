import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Message } from "../shared/models/Message";

@Injectable({providedIn: 'root'})
export class ChatService {
  constructor(private http: HttpClient) {}

  getPreviousChatMessage(patientId: number, doctorId: number): Observable<Message[]> {
    return this.http.get<Message[]>('http://localhost:8088/api/message/' + patientId + '/' + doctorId);
  }
}
