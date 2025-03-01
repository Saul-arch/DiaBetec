package com.example.practica14_practicafinal.Services;

import com.example.practica14_practicafinal.dao.RGlucosaRepository;
import com.example.practica14_practicafinal.dao.UsersRepository;
import com.example.practica14_practicafinal.models.Glucosa;
import com.example.practica14_practicafinal.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GlucosaService {
    @Autowired
    RGlucosaRepository rglucosaRepository;
    @Autowired
    UsersRepository usersRepository;

    /*public Glucosa guardarMedicionGlucosa(String gmail, double nivelGlucosa) {
        Usuario usuario = usuarioRepository.findByGmail(gmail);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Glucosa glucosa = new Glucosa();
        glucosa.setNivelGlucosa(nivelGlucosa);
        glucosa.setFechaMedicion(LocalDateTime.now());
        glucosa.setUsuario(usuario);

        return glucosaRepository.save(glucosa);
    }*/

    public void guardarRegistroGlucosa(String gmail, double nivelGlucosa) {
        Users usuario = usersRepository.findByGmail(gmail);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
        }else {

            Glucosa glucosa;
            glucosa = new Glucosa();

            glucosa.setNivel_glucosa(nivelGlucosa);
            glucosa.setFecha(LocalDateTime.now());
            glucosa.setNotas("gjhgjjjjk");
            glucosa.setUsuario(usuario);

            rglucosaRepository.save(glucosa);

        }
    }


}
