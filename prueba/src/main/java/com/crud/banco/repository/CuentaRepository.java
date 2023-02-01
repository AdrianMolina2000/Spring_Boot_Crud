package com.crud.banco.repository;

import com.crud.banco.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuentaRepository implements ICuentaRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cuenta> findAll(int idCliente) {
        String SQL = "SELECT * FROM cuenta WHERE estado = 1 AND id_cliente = " + idCliente;
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Cuenta.class));
    }

    @Override
    public int addAccount(Cuenta cuenta) {
        String SQL = "INSERT INTO cuenta values (?, ?, SYSDATETIME(), 1, ?)";
        return jdbcTemplate.update(SQL, new Object[]{cuenta.getTipo(), cuenta.getTotal(), cuenta.getId_cliente()});
    }

    @Override
    public int acreditarAccount(Cuenta cuenta) {
        String SQL = "UPDATE cuenta SET total=total+? WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{cuenta.getTotal(), cuenta.getId()});
    }

    @Override
    public int debitarAccount(Cuenta cuenta) {
        String SQL = "UPDATE cuenta SET total=total-? WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{cuenta.getTotal(), cuenta.getId()});
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE cuenta SET estado=0 WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
}
