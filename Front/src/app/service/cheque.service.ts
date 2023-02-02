import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ChequeModel } from '../model/cheque-model';

@Injectable({
  providedIn: 'root'
})
export class ChequeService {

  constructor(private httpClient: HttpClient) { }

  getCheque(id: number): Observable<ChequeModel[]> {
    return this.httpClient.get<ChequeModel[]>('http://localhost:9000/api/cheque' + '/list/' + id).pipe(map(res => res));
  }

  canjearCheque(request: any): Observable<any> {
    return this.httpClient.post<any>('http://localhost:9000/api/cheque' + '/canjearCheque', request).pipe(map(res => res));
  }

  deleteCheque(id: number): Observable<any> {
    return this.httpClient.get<any>('http://localhost:9000/api/cheque' + '/delete/' + id).pipe(map(res => res));
  }
}
