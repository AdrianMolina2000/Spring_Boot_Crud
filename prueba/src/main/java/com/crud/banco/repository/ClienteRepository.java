package com.crud.banco.repository;

import com.crud.banco.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository implements IClienteRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cliente> findAll() {
        String SQL = "SELECT * FROM cliente where estado=1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Cliente.class));
    }

    @Override
    public int save(Cliente cliente) {
        String SQL = "INSERT INTO cliente VALUES(?,?,?,1)";
        return jdbcTemplate.update(SQL, new Object[]{cliente.getNombres(), cliente.getDireccion(), cliente.getTelefono()});
    }

    @Override
    public int update(Cliente cliente) {
        String SQL = "UPDATE cliente SET nombres=?, direccion=?, telefono=? WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{cliente.getNombres(), cliente.getDireccion(), cliente.getTelefono(), cliente.getId()});
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE cliente SET estado=0 WHERE id=?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
}
