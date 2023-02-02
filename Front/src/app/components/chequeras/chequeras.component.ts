import { Component, OnInit } from '@angular/core';
import { ChequeraModel } from 'src/app/model/chequera-model';
import { ComunicacionService } from 'src/app/service/comunicacion.service';
import { FormGroup, FormControl } from '@angular/forms';
import { ChequeraService } from 'src/app/service/chequeras.service';

@Component({
  selector: 'app-chequeras',
  templateUrl: './chequeras.component.html',
  styleUrls: ['./chequeras.component.sass']
})
export class ChequerasComponent implements OnInit {

  idCliente: number = 0;

  listChequera: ChequeraModel[] = [];
  formChequera: FormGroup = new FormGroup({});

  constructor(private chequeraService: ChequeraService, private comunicacionService: ComunicacionService) { }

  ngOnInit(): void {
    this.comunicacionService.idUsuarioCuenta.subscribe(resp => {
      this.idCliente = resp;
      this.list(resp);
    });

    this.formChequera = new FormGroup({
      id: new FormControl(''),
      cantidad: new FormControl(''),
      fecha_creacion: new FormControl(''),
      estado: new FormControl(''),
      id_cliente: new FormControl(''),
    });
  }

  list(id: number) {
    this.chequeraService.getChequera(id).subscribe(resp => {
      if (resp) {
        this.listChequera = resp;
      }
    });
  }

  save() {
    this.formChequera.controls['id_cliente'].setValue(this.idCliente);
    this.chequeraService.setChequera(this.formChequera.value).subscribe(resp => {
      if (resp) {
        this.list(this.idCliente);
        this.formChequera.reset();
      }
    }
    );
  }

  delete(id: any) {
    this.chequeraService.deleteChequera(id).subscribe(resp => {
      if (resp) {
        this.list(this.idCliente);
      }
    }
    );
  }

  newChequera() {
    this.formChequera.reset();
  }
}
