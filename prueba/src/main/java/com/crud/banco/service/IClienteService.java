package com.crud.banco.service;

import com.crud.banco.model.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();
    public int save(Cliente cliente);
    public int update(Cliente cliente);
    public int deleteById(int id);
}
