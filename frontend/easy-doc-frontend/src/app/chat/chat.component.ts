import { Component, OnInit } from '@angular/core';
import Pusher from 'pusher-js';
import { ActivatedRoute } from '@angular/router';
import { Message } from '../shared/models/Message';
import { Patient } from '../shared/models/Patient';
import { HttpClient } from '@angular/common/http';
import { ChatService } from './chat.service';
import { Store } from '@ngrx/store';
import * as fromApp from '../auth/store/app.reducer';
import { PatientService } from '../patient/patients.service';
import { DoctorService } from '../doctor/doctor.service';
import { AuthService } from '../auth/auth.service';
import { Doctor } from '../shared/models/Doctor';


@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
  loggedIn = "";
  messageTyped: string = "";
  activeChat: string = "";
  chatDoctorId: number = -1;
  chatPatientId: number = 1;
  consultId: number = -1;
  chatDoctor: any;
  chatPatient: any;

  messages: Message[] = [];

  msss: any[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private http: HttpClient,
    private chatService: ChatService,
    private patientService: PatientService,
    private doctorService: DoctorService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {

    Pusher.logToConsole = true;

    this.activatedRoute.params.subscribe(
      (params) => {

        this.chatPatientId = params['patientId'];
        this.chatDoctorId = params['doctorId'];
        this.consultId = params['consultId'];


        this.authService.userSubject.subscribe(
          (user: any) => {

            if (user.patientId) {
              this.activeChat = 'patient';
              this.loggedIn = 'patient';
              this.chatPatient = user;
              this.doctorService.getDoctorById(this.chatDoctorId).subscribe(
                (doc) => this.chatDoctor = doc
              )

            } else {
              this.activeChat = 'doctor';
              this.loggedIn = 'doctor';
              this.chatDoctor = user;
              this.patientService.getPatientById(this.chatPatientId).subscribe(
                (pat) => this.chatPatient = pat
              )
            }
          }
        )

        // push initial messages if there is already a chat
        this.chatService.getPreviousChatMessage(this.chatPatientId, this.chatDoctorId).subscribe(
          (previousMessages) => {
            this.messages = previousMessages;
          }
        )

        const pusher = new Pusher('34ba18071d982e21615a', {
          cluster: 'mt1'
        });

        const channelName = "p" + this.chatPatientId + "d" + this.chatDoctorId.toString();
        const channel = pusher.subscribe(channelName);
        channel.bind('chat', (data: any) => {
          this.messages.push(data.message)
        });

      }
    )


  }

  onSendClick() {
    const mssgObj = new Message(this.chatDoctorId, this.chatPatientId, this.messageTyped, this.getDateTimeString(), this.loggedIn);
    this.http.post('http://localhost:8088/api/message/push/' + this.chatPatientId + "/" + this.chatDoctorId.toString(),
      mssgObj
      ,
      {
        // params: new HttpParams().set('patientId', 1).set('doctorId', this.chatDoctorId),  // can be sent like this also
        responseType: 'text'
      }).subscribe(
        () => {
          this.messageTyped = "";
        }
      )
  }

  getDateTimeString() {
    return new Date().toLocaleString("en-GB", {
      day: "numeric",
      month: "short",
      year: "numeric",
      hour: "numeric",
      minute: "2-digit"
    });
  }

}

