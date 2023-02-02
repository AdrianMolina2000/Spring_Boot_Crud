export class ChequeModel{
    id: number = 0;
    lugar: string = '';
    fecha_canje: Date = new Date();
    total: number = 0;
    destinatario: string = '';
    estado: string = '';
    id_chequera: number = 0;
}