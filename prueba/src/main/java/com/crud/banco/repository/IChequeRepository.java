package com.crud.banco.repository;

import com.crud.banco.model.Cheque;

import java.util.List;

public interface IChequeRepository {
    public List<Cheque> findAll();
    public int save(Cheque cheque);
    public int update(Cheque cheque);
    public int deleteById(int id);
}
