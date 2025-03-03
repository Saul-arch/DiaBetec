package com.example.practica14_practicafinal.dao;

import com.example.practica14_practicafinal.models.Glucosa;
import com.example.practica14_practicafinal.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RGlucosaRepository extends JpaRepository<Glucosa, Integer> {

    List<Glucosa> findAllByUsuario(Users usuario);
}
