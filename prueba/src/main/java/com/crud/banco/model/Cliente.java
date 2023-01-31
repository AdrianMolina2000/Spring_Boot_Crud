package com.crud.banco.model;

import java.util.Date;

import lombok.Data;

@Data
public class Cliente {
    private int id;
    private String nombres;
    private String direccion;
    private String telefono;
    private char estado;
}
