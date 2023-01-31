package com.crud.banco.service;

import com.crud.banco.model.Cliente;
import com.crud.banco.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public List<Cliente> findAll() {
        List<Cliente> list;
        try{
            list = iClienteRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Cliente cliente) {
        int row;
        try{
            row = iClienteRepository.save(cliente);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Cliente cliente) {
        int row;
        try{
            row = iClienteRepository.update(cliente);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try{
            row = iClienteRepository.deleteById(id);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
