package com.crud.banco.controller;

import com.crud.banco.model.Chequera;
import com.crud.banco.model.ServiceResponse;
import com.crud.banco.service.IChequeraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chequera")
@CrossOrigin("*")
public class ChequeraController {
    @Autowired
    private IChequeraService iChequeraService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Chequera>> list(@PathVariable int id){
        var result = iChequeraService.findAll(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/crearChequera")
    public ResponseEntity<ServiceResponse> save(@RequestBody Chequera chequera){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iChequeraService.addChequera(chequera);
        if(result == 1){
            serviceResponse.setMessage("Chequera creada con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iChequeraService.deleteById(id);
        if(result == 1){
            serviceResponse.setMessage("Chequera eliminada con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
