package com.crud.banco.service;

import com.crud.banco.model.Chequera;
import com.crud.banco.repository.IChequeraRepository;
import com.crud.banco.repository.ICuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChequeraService implements IChequeraService{
    @Autowired
    private IChequeraRepository iChequeraRepository;
    @Override
    public List<Chequera> findAll(int idCliente) {
        List<Chequera> list;
        try{
            list = iChequeraRepository.findAll(idCliente);
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int addChequera(Chequera chequera) {
        int row;
        try{
            row = iChequeraRepository.addChequera(chequera);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try{
            row = iChequeraRepository.deleteById(id);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
