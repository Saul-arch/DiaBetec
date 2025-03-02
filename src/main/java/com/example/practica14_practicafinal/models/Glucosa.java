package com.example.practica14_practicafinal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "glucosa")
public class Glucosa {
    @Id
    private int id_glucosa;
    private double nivel_glucosa;
    private LocalDateTime fecha;
    private String hora;
    private String notas;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user") // Llave Foránea
    @JsonIgnore
    private Users usuario;

    public int getId_glucosa() {
        return id_glucosa;
    }

    public void setId_glucosa(int id_glucosa) {
        this.id_glucosa = id_glucosa;
    }

    public double getNivel_glucosa() {
        return nivel_glucosa;
    }

    public void setNivel_glucosa(double nivel_glucosa) {
        this.nivel_glucosa = nivel_glucosa;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
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

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
}
