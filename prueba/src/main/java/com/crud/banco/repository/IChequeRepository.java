package com.crud.banco.repository;

import com.crud.banco.model.Cheque;

import java.util.List;

public interface IChequeRepository {
    public List<Cheque> findAll(int idChequera);
    public int addCheque(Cheque cheque);
    public int canjearCheque(Cheque cheque);
    public int deleteById(int id);
}
