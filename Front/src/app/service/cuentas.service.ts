import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CuentaModel } from '../model/cuenta-model';

@Injectable({
  providedIn: 'root'
})
export class CuentasService {

  constructor(private httpClient: HttpClient) { }

  getAccount(id: number): Observable<CuentaModel[]> {
    return this.httpClient.get<CuentaModel[]>('http://localhost:9000/api/cuenta' + '/list/' + id).pipe(map(res => res));
  }

  setAccount(request: any): Observable<any> {
    return this.httpClient.post<any>('http://localhost:9000/api/cuenta' + '/crearCuenta', request).pipe(map(res => res));
  }

  acreditarAccount(request: any): Observable<any> {
    return this.httpClient.post<any>('http://localhost:9000/api/cuenta' + '/acreditar', request).pipe(map(res => res));
  }
  
  debitarAccount(request: any): Observable<any> {
    return this.httpClient.post<any>('http://localhost:9000/api/cuenta' + '/debitar', request).pipe(map(res => res));
  }

  deleteAccount(id: number): Observable<any> {
    return this.httpClient.get<any>('http://localhost:9000/api/cuenta' + '/delete/' + id).pipe(map(res => res));
  }
}
