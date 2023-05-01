export class Message {
  constructor(
    public doctorId: number,
    public patientId: number,
    public message: string,
    public timestamp: string,
    public messageBy: string
  ) { }
}
