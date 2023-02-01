package com.crud.banco.service;

import com.crud.banco.model.Chequera;

import java.util.List;

public interface IChequeraService {
    public List<Chequera> findAll(int idCliente);
    public int addChequera(Chequera chequera);
    public int deleteById(int id);
}
