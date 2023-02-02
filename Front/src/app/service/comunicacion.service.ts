import { Injectable, EventEmitter } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class ComunicacionService {

  idUsuarioCuenta: EventEmitter<number> = new EventEmitter<number>();
  constructor() { }
}
