package com.example.practica14_practicafinal.models;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "glucosa")
public class Glucosa {
    @Id
    private int id_glucosa;
    private String nivel_glucosa;
    private String fecha;
    private String hora;
    private String notas;

    public int getId_glucosa() {
        return id_glucosa;
    }

    public void setId_glucosa(int id_glucosa) {
        this.id_glucosa = id_glucosa;
    }

    public String getNivel_glucosa() {
        return nivel_glucosa;
    }

    public void setNivel_glucosa(String nivel_glucosa) {
        this.nivel_glucosa = nivel_glucosa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
