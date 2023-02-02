import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClienteModel } from '../model/cliente-model';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private httpClient: HttpClient) {

  }

  getClient(): Observable<ClienteModel[]>{
    return this.httpClient.get<ClienteModel[]>('http://localhost:9000/api/cliente' + '/list').pipe(map(res => res));
  }
  
  setClient(request: any): Observable<any>{
    return this.httpClient.post<any>('http://localhost:9000/api/cliente' + '/crearCliente', request).pipe(map(res => res));
  }
  
  putClient(request: any): Observable<any>{
    return this.httpClient.post<any>('http://localhost:9000/api/cliente' + '/update', request).pipe(map(res => res));
  }
  
  deleteClient(id: number): Observable<any>{
    return this.httpClient.get<any>('http://localhost:9000/api/cliente' + '/delete/' + id).pipe(map(res => res));
  }
}
