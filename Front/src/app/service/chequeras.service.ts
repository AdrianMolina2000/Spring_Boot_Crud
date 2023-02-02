import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ChequeraModel } from '../model/chequera-model';

@Injectable({
  providedIn: 'root'
})
export class ChequeraService {

  constructor(private httpClient: HttpClient) { }

  getChequera(id: number): Observable<ChequeraModel[]> {
    return this.httpClient.get<ChequeraModel[]>('http://localhost:9000/api/chequera' + '/list/' + id).pipe(map(res => res));
  }

  setChequera(request: any): Observable<any> {
    return this.httpClient.post<any>('http://localhost:9000/api/chequera' + '/crearChequera', request).pipe(map(res => res));
  }

  deleteChequera(id: number): Observable<any> {
    return this.httpClient.get<any>('http://localhost:9000/api/chequera' + '/delete/' + id).pipe(map(res => res));
  }
}
