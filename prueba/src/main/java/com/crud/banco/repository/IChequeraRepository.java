package com.crud.banco.repository;

import com.crud.banco.model.Chequera;

import java.util.List;

public interface IChequeraRepository {
    public List<Chequera> findAll(int idCliente);
    public int addChequera(Chequera chequera);
    public int deleteById(int id);
}
