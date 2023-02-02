import { Component, OnInit, Input } from '@angular/core';
import { ChequeModel } from 'src/app/model/cheque-model';
import { ComunicacionService } from 'src/app/service/comunicacion.service';
import { FormGroup, FormControl } from '@angular/forms';
import { ChequeService } from 'src/app/service/cheque.service';

@Component({
  selector: 'app-cheque',
  templateUrl: './cheque.component.html',
  styleUrls: ['./cheque.component.sass']
})
export class ChequeComponent implements OnInit {

  @Input() id_chequera: string = "";

  listCheque: ChequeModel[] = [];
  formCheque: FormGroup = new FormGroup({});

  constructor(private chequeService: ChequeService, private comunicacionService: ComunicacionService) { }

  ngOnInit(): void {
    this.list(Number(this.id_chequera));

    this.formCheque = new FormGroup({
      id: new FormControl(''),
      lugar: new FormControl(''),
      fecha_canje: new FormControl(''),
      total: new FormControl(''),
      destinatario: new FormControl(''),
      estado: new FormControl(''),
      id_chequera: new FormControl(''),
    });
  }

  list(id: number) {
    this.chequeService.getCheque(id).subscribe(resp => {
      if (resp) {
        this.listCheque = resp;
      }
    });
  }

  save() {
    this.formCheque.controls['id_chequera'].setValue(this.id_chequera);
    this.chequeService.canjearCheque(this.formCheque.value).subscribe(resp => {
      if (resp) {
        this.list(Number(this.id_chequera));
        this.formCheque.reset();
      }
    }
    );
  }

  delete(id: any) {
    this.chequeService.deleteCheque(id).subscribe(resp => {
      if (resp) {
        this.list(Number(this.id_chequera));
      }
    }
    );
  }

  newCheque() {
    this.formCheque.reset();
  }
}
