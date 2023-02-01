package com.crud.banco.repository;

import com.crud.banco.model.Chequera;
import com.crud.banco.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChequeraRepository implements IChequeraRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Chequera> findAll(int idCliente) {
        String SQL = "SELECT * FROM chequera WHERE estado = 1 AND id_cliente = " + idCliente;
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Chequera.class));
    }

    @Override
    public int addChequera(Chequera chequera) {
        String SQL = "INSERT INTO chequera values (?, SYSDATETIME(), 1, ?)";
        return jdbcTemplate.update(SQL, new Object[]{chequera.getCantidad(), chequera.getId_cliente()});
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE chequera SET estado=0 WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
}
