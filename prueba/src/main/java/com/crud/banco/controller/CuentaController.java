package com.crud.banco.controller;

import com.crud.banco.model.Cuenta;
import com.crud.banco.model.ServiceResponse;
import com.crud.banco.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cuenta")
@CrossOrigin("*")
public class CuentaController {
    @Autowired
    private ICuentaService iCuentaService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Cuenta>> list(@PathVariable int id){
        var result = iCuentaService.findAll(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/crearCuenta")
    public ResponseEntity<ServiceResponse> save(@RequestBody Cuenta cuenta){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iCuentaService.addAccount(cuenta);
        if(result == 1){
            serviceResponse.setMessage("Cuenta creada con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/acreditar")
    public ResponseEntity<ServiceResponse> acreditar(@RequestBody Cuenta cuenta){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iCuentaService.acreditarAccount(cuenta);
        if(result == 1){
            serviceResponse.setMessage("Cuenta acreditada con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/debitar")
    public ResponseEntity<ServiceResponse> debitar(@RequestBody Cuenta cuenta){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iCuentaService.debitarAccount(cuenta);
        if(result == 1){
            serviceResponse.setMessage("Cuenta debitada con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iCuentaService.deleteById(id);
        if(result == 1){
            serviceResponse.setMessage("Cuenta eliminada con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
