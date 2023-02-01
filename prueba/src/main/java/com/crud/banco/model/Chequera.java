package com.crud.banco.model;

import java.util.Date;

import lombok.Data;

@Data
public class Chequera {
    private int id;
    private int cantidad;
    private Date fecha_creacion;
    private int id_cliente;
}
