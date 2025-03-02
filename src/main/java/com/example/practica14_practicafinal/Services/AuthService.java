package com.example.practica14_practicafinal.Services;

import com.example.practica14_practicafinal.models.Users;
import com.example.practica14_practicafinal.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

    @Autowired
    JWTUtil jwtUtil;

    @PersistenceContext
    EntityManager entityManager;
    public List<String> login(String correo, String password) {

        List<String> respuesta = new ArrayList<>();

        String query = "From Users where gmail=:gmail";

        List<Users> list = entityManager.createQuery(query, Users.class)
                .setParameter("gmail", correo).getResultList();

        if (!list.isEmpty()) {
            if (argon2.verify(list.get(0).getPassword(), password)) {
                System.out.println("Las credenciales son correctas");

                respuesta.add(generarToken(list.get(0)));
                respuesta.add(list.get(0).getNombre());
                respuesta.add(list.get(0).getApellidoM());

                return respuesta;
            }
        }
        System.out.println("Correo o contraseñas incorrectas");
        respuesta.add("FAIL");
        return respuesta;
    }

    private String generarToken(Users user) {
        return jwtUtil.create(String.valueOf(user.getId_user()), user.getGmail());
    }

    public String validarToken(String token){
        if (jwtUtil.getKey(token) != null){
            System.out.println("True");
            return "True";
        }else {
            System.out.println("Sin autorizacion (Redirige al login)");
            return "False";
        }
    }
}
