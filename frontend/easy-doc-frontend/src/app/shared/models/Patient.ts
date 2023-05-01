export class Patient {
  constructor(
    public patientId: number,
    public name: string,
    public email: string,
    public password: string,
    public height: number,
    public weight: number,
    public age: number,
    public profileImg: string
  ) { }
}
