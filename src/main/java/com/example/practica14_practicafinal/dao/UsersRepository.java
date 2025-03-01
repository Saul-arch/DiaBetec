package com.example.practica14_practicafinal.dao;

import com.example.practica14_practicafinal.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
