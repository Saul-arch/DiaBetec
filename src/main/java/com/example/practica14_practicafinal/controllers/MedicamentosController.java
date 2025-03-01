package com.example.practica14_practicafinal.controllers;

import com.example.practica14_practicafinal.Services.GlucosaService;
import com.example.practica14_practicafinal.models.GlucosaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicine")
public class MedicamentosController {
    @Autowired
    GlucosaService glucosaService;

    @RequestMapping(value = "/addRGlucosa", method = RequestMethod.POST)
    public void addRGlucosa(@RequestBody GlucosaDTO glucosa){
        glucosaService.guardarRegistroGlucosa(glucosa.getGmail(), glucosa.getNivelGlucosa());
    }
}