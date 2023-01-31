package com.crud.banco.model;

import java.util.Date;

import lombok.Data;

@Data
public class Cheque {
    private int id;
    private String lugar;
    private Date fecha_Canje;
    private double total;
    private String destinatario;
    private boolean canjeado;
}
