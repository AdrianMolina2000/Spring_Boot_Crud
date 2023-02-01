package com.crud.banco.model;

import java.util.Date;

import lombok.Data;

@Data
public class Cuenta {
    private int id;
    private int tipo;
    private double total;
    private Date fecha_creacion;
    private char estado;
    private int id_cliente;
}
