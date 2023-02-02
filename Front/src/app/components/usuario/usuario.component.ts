import { Component, OnInit } from '@angular/core';
import { ClienteModel } from 'src/app/model/cliente-model';
import { UsuarioService } from 'src/app/service/usuario.service';
import { FormGroup, FormControl } from '@angular/forms';
import { ComunicacionService } from 'src/app/service/comunicacion.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.sass']
})
export class UsuarioComponent implements OnInit {

  listClients: ClienteModel[] = [];
  formClient: FormGroup = new FormGroup({});
  isUpdate: boolean = false;

  constructor(private usuarioService: UsuarioService, private comunicacionService: ComunicacionService) { }

  pasarIdUsuarioCuenta(id: number) {
    this.comunicacionService.idUsuarioCuenta.emit(id);
  }

  ngOnInit(): void {
    this.list();
    this.formClient = new FormGroup({
      id: new FormControl(''),
      nombres: new FormControl(''),
      direccion: new FormControl(''),
      telefono: new FormControl(''),
    });
  }

  list() {
    this.usuarioService.getClient().subscribe(resp => {
      if (resp) {
        this.listClients = resp;
      }
    });
  }

  save() {
    // this.formClient.controls['noMapeado'].setValue('1');
    this.usuarioService.setClient(this.formClient.value).subscribe(resp => {
      if (resp) {
        this.list();
        this.formClient.reset();
      }
    }
    );
  }
  
  update() {
    this.usuarioService.putClient(this.formClient.value).subscribe(resp => {
      if (resp) {
        this.list();
        this.formClient.reset();
      }
    }
    );
  }
  
  delete(id: any) {
    this.usuarioService.deleteClient(id).subscribe(resp => {
      if (resp) {
        this.list();
      }
    }
    );
  }

  newClient() {
    this.isUpdate = false;
    this.formClient.reset();
  }

  selectItem(item: any) {
    this.isUpdate = true;
    this.formClient.controls['id'].setValue(item.id);
    this.formClient.controls['nombres'].setValue(item.nombres);
    this.formClient.controls['direccion'].setValue(item.direccion);
    this.formClient.controls['telefono'].setValue(item.telefono);
  }

}
