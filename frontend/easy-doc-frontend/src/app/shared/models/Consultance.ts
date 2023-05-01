import { Doctor } from "./Doctor";

export class Consultance {
  constructor(
    public patientId: number,
    public doctorId: number,
    public dateTime: string
  ) {}
}
