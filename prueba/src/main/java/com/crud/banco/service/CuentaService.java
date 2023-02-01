package com.crud.banco.service;

import com.crud.banco.model.Cuenta;
import com.crud.banco.repository.ICuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService implements ICuentaService{
    @Autowired
    private ICuentaRepository iCuentaRepository;
    @Override
    public List<Cuenta> findAll(int idCliente) {
        List<Cuenta> list;
        try{
            list = iCuentaRepository.findAll(idCliente);
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int addAccount(Cuenta cuenta) {
        int row;
        try{
            row = iCuentaRepository.addAccount(cuenta);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int acreditarAccount(Cuenta cuenta) {
        int row;
        try{
            row = iCuentaRepository.acreditarAccount(cuenta);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int debitarAccount(Cuenta cuenta) {
        int row;
        try{
            row = iCuentaRepository.debitarAccount(cuenta);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try{
            row = iCuentaRepository.deleteById(id);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
