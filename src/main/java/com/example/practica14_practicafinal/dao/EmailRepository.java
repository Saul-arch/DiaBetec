package com.example.practica14_practicafinal.dao;

import com.example.practica14_practicafinal.models.CodigoVerficacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<CodigoVerficacion, Integer> {
    CodigoVerficacion findByCodigoAndGmail(String codigo, String gmail);
}
