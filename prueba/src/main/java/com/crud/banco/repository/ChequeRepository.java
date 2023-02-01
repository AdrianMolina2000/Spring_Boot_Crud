package com.crud.banco.repository;

import com.crud.banco.model.Cheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChequeRepository implements IChequeRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cheque> findAll(int idChequera) {
        String SQL = "SELECT * FROM cheque WHERE id_chequera = " + idChequera;
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Cheque.class));
    }

    @Override
    public int addCheque(Cheque cheque) {
        String SQL = "INSERT INTO cheque (estado, id_chequera) values (1, ?)";
        return jdbcTemplate.update(SQL, new Object[]{cheque.getId_chequera()});
    }

    @Override
    public int canjearCheque(Cheque cheque) {
        String SQL = "UPDATE cheque SET lugar = ? , fecha_canje = SYSDATETIME(), total = ?, destinatario = ?, estado = 2 WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{cheque.getLugar(), cheque.getTotal(), cheque.getDestinatario(), cheque.getId_chequera()});
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE cheque SET estado=0 WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
}
