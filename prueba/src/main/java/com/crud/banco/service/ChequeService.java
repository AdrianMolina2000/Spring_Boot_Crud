package com.crud.banco.service;

import com.crud.banco.model.Cheque;
import com.crud.banco.repository.IChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChequeService implements IChequeService{
    @Autowired
    private IChequeRepository iChequeRepository;
    @Override
    public List<Cheque> findAll(int idChequera) {
        List<Cheque> list;
        try{
            list = iChequeRepository.findAll(idChequera);
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int addCheque(Cheque cheque) {
        int row;
        try{
            row = iChequeRepository.addCheque(cheque);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int canjearCheque(Cheque cheque) {
        int row;
        try{
            row = iChequeRepository.canjearCheque(cheque);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try{
            row = iChequeRepository.deleteById(id);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
