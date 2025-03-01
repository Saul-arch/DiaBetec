package com.example.practica14_practicafinal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "codigo_correo")
public class CodigoVerficacion {
    @Id
    private int id;
    private String codigo;
    private String gmail;
    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_expiracion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDateTime getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(LocalDateTime fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }
}
