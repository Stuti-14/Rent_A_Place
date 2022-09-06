import { Answer } from "./answer";

export class Question {
    public id!: number;
    public question!: string;
    public userid!: number;
    public username!: string;
    public answers!: Answer[]
    constructor() {

    }
}
