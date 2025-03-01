package com.example.practica14_practicafinal.controllers;

import com.example.practica14_practicafinal.Services.UserService;
import com.example.practica14_practicafinal.dao.UsersRepository;
import com.example.practica14_practicafinal.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ControllersUsers {
    @Autowired
    UserService userService;

    //Meotodo para listar todos los usarios de la BD
    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public List<Users> getAllUsers(@RequestHeader(value = "Authorization") String token) {
        return userService.getAllUsers(token);
    }

    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable int id, @RequestHeader(value = "Authorization") String token) {
        userService.deleteUserById(id, token);
    }

    @RequestMapping(value = "/searchuser/{id}", method = RequestMethod.GET)
    public Users getUserById(@PathVariable int id, @RequestHeader(value = "Authorization") String token) {
        return userService.getUserById(id, token);
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public void addUser(@RequestBody Users usuario){
        userService.addUser(usuario);
    }
}
