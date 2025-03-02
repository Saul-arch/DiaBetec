package com.example.practica14_practicafinal.controllers;

import com.example.practica14_practicafinal.Services.GlucosaService;
import com.example.practica14_practicafinal.models.Glucosa;
import com.example.practica14_practicafinal.models.GlucosaDTO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicamentosController {
    @Autowired
    GlucosaService glucosaService;

    @RequestMapping(value = "/addRGlucosa", method = RequestMethod.POST)
    public void addRGlucosa(@RequestHeader(value = "Authorization") String token, @RequestBody GlucosaDTO glucosa){
        glucosaService.guardarRegistroGlucosa(token, glucosa);
    }

    @GetMapping(value = "/getAll")
    public List<Glucosa> getAllRegistros(@RequestHeader(value = "Authorization") String token){
        return glucosaService.obtenerRegistroGlucoas(token);
    }
}