export class Doctor {
  constructor(
    public doctorId: number,
    public name: string,
    public email: string,
    public password: string,
    public specialist: string,
    public fees: number,
    public experience: number,
    public profileImg: string
  ) { }
}
