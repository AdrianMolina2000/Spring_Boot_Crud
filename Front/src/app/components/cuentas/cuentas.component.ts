import { Component, OnInit } from '@angular/core';
import { CuentaModel } from 'src/app/model/cuenta-model';
import { ComunicacionService } from 'src/app/service/comunicacion.service';
import { FormGroup, FormControl } from '@angular/forms';
import { CuentasService } from 'src/app/service/cuentas.service';

@Component({
  selector: 'app-cuentas',
  templateUrl: './cuentas.component.html',
  styleUrls: ['./cuentas.component.sass']
})
export class CuentasComponent implements OnInit {

  idCliente: number = 0;
  totalAgregar: number = 0;
  valor: number = 0;

  listCuentas: CuentaModel[] = [];
  formCuenta: FormGroup = new FormGroup({});
  isAhorro: boolean = false;

  constructor(private cuentasService: CuentasService, private comunicacionService: ComunicacionService) { }

  ngOnInit(): void {
    this.comunicacionService.idUsuarioCuenta.subscribe(resp => {
      this.idCliente = resp;
      this.list(resp);
    });

    this.formCuenta = new FormGroup({
      id: new FormControl(''),
      tipo: new FormControl(''),
      total: new FormControl(''),
      id_cliente: new FormControl(''),
    });
  }

  list(id: number) {
    this.cuentasService.getAccount(id).subscribe(resp => {
      if (resp) {
        this.listCuentas = resp;
      }
    });
  }

  save() {
    this.formCuenta.controls['tipo'].setValue(this.isAhorro ? '1' : '2');
    this.formCuenta.controls['id_cliente'].setValue(this.idCliente);
    this.cuentasService.setAccount(this.formCuenta.value).subscribe(resp => {
      if (resp) {
        this.list(this.idCliente);
        this.formCuenta.reset();
      }
    }
    );
  }

  acreditar(id: any) {
    this.valor = Number((<HTMLInputElement>document.getElementById("totalAcreditar")).value);
    this.formCuenta.controls['total'].setValue(this.valor);
    this.formCuenta.controls['id'].setValue(id);
    this.cuentasService.acreditarAccount(this.formCuenta.value).subscribe(resp => {
      if (resp) {
        this.list(this.idCliente);
        this.formCuenta.reset();
      }
    }
    );
  }

  debitar(id: any) {
    this.valor = Number((<HTMLInputElement>document.getElementById("totalAcreditar")).value);
    this.formCuenta.controls['total'].setValue(this.valor);
    this.formCuenta.controls['id'].setValue(id);
    this.cuentasService.debitarAccount(this.formCuenta.value).subscribe(resp => {
      if (resp) {
        this.list(this.idCliente);
        this.formCuenta.reset();
      }
    }
    );
  }

  delete(id: any) {
    this.cuentasService.deleteAccount(id).subscribe(resp => {
      if (resp) {
        this.list(this.idCliente);
      }
    }
    );
  }

  newAccount() {
    this.formCuenta.reset();
  }

  cambiarCuenta(cuenta: boolean) {
    this.isAhorro = cuenta;
  }
}
