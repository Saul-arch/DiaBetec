package com.example.practica14_practicafinal.controllers;

import com.example.practica14_practicafinal.Services.AuthService;
import com.example.practica14_practicafinal.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Users user) {
        return authService.login(user.getGmail(), user.getPassword());
    }

    @RequestMapping(value = "/validator", method = RequestMethod.POST)
    public String validarToken(@RequestHeader("Authorization") String token) {

        return authService.validarToken(token);
    }

}
