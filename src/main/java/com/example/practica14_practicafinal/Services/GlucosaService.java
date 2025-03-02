package com.example.practica14_practicafinal.Services;

import com.example.practica14_practicafinal.dao.RGlucosaRepository;
import com.example.practica14_practicafinal.dao.UsersRepository;
import com.example.practica14_practicafinal.models.Glucosa;
import com.example.practica14_practicafinal.models.GlucosaDTO;
import com.example.practica14_practicafinal.models.Users;
import com.example.practica14_practicafinal.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GlucosaService {
    @Autowired
    RGlucosaRepository rglucosaRepository;
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    JWTUtil jwtUtil;

    public void guardarRegistroGlucosa(String token, GlucosaDTO glucosa) {

        if (jwtUtil.getKey(token) == null){
            System.out.println("Sin authorizacion");
            return;
        }


        Users usuario = usersRepository.findByGmail(glucosa.getGmail());

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
        }else {

            Glucosa glucosaNueva;
            glucosaNueva = new Glucosa();

            glucosaNueva.setNivel_glucosa(glucosa.getNivelGlucosa());
            glucosaNueva.setFecha(LocalDateTime.now());
            glucosaNueva.setNotas(glucosa.getNotas());
            glucosaNueva.setUsuario(usuario);

            rglucosaRepository.save(glucosaNueva);

        }
    }

    public List<Glucosa> obtenerRegistroGlucoas(String token) {

        Users UsuarioLogueado = ObtenerGmailUser(token);

        return rglucosaRepository.findAllByUsuario(UsuarioLogueado);
    }
    public Users ObtenerGmailUser(String token) {
        if (jwtUtil.getKey(token) == null){
            return null;
        }
        String gmailuser = jwtUtil.getValue(token);

        System.out.println("EL IDE DEL USUARIO ES: " + gmailuser);

        return usersRepository.findByGmail(gmailuser);
    }


}
