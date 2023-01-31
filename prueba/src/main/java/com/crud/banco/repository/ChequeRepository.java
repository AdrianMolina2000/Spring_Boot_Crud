package com.crud.banco.repository;

import com.crud.banco.model.Cheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ChequeRepository implements IChequeRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Cheque> findAll() {
        String SQL = "SELECT * FROM cheque";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Cheque.class));
    }
    @Override
    public int save(Cheque cheque) {
        String SQL = "INSERT INTO cheque VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{cheque.getId(), cheque.getLugar(), cheque.getFecha_Canje(), cheque.getTotal(), cheque.getDestinatario(), cheque.getTotal()});
    }

    @Override
    public int update(Cheque cheque) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
