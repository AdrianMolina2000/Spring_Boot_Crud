package com.crud.banco.controller;

import com.crud.banco.model.Cliente;
import com.crud.banco.model.ServiceResponse;
import com.crud.banco.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    private IClienteService iClienteService;

    @GetMapping("/list")
    public ResponseEntity<List<Cliente>> list(){
        var result = iClienteService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/crearCliente")
    public ResponseEntity<ServiceResponse> save(@RequestBody Cliente cliente){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iClienteService.save(cliente);
        if(result == 1){
            serviceResponse.setMessage("Cliente creado con Exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Cliente cliente){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iClienteService.update(cliente);
        if(result == 1){
            serviceResponse.setMessage("Cliente actualizado con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        var result = iClienteService.deleteById(id);
        if(result == 1){
            serviceResponse.setMessage("Cliente eliminado con exito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
