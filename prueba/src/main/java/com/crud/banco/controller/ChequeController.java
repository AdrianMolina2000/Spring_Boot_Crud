package com.crud.banco.controller;

import com.crud.banco.model.Cheque;
import com.crud.banco.model.ServiceResponse;
import com.crud.banco.service.IChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cheque")
@CrossOrigin("*")
public class ChequeController {
    @Autowired
    private IChequeService iChequeService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Cheque>> list(@PathVariable int id){
        var result = iChequeService.findAll(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/crearCheque")
    public ResponseEntity<ServiceResponse> save(@RequestBody Cheque cheque){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iChequeService.addCheque(cheque);
        if(result == 1){
            serviceResponse.setMessage("Cheque creado con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/canjearCheque")
    public ResponseEntity<ServiceResponse> acreditar(@RequestBody Cheque cheque){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iChequeService.canjearCheque(cheque);
        if(result == 1){
            serviceResponse.setMessage("Cheque canjeado con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iChequeService.deleteById(id);
        if(result == 1){
            serviceResponse.setMessage("Cheque eliminado con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
