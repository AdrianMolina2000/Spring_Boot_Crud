package com.crud.banco.repository;

import com.crud.banco.model.Cuenta;

import java.util.List;

public interface ICuentaRepository {
    public List<Cuenta> findAll(int idCliente);
    public int addAccount(Cuenta cuenta);
    public int acreditarAccount(Cuenta cuenta);
    public int debitarAccount(Cuenta cuenta);
    public int deleteById(int id);
}
