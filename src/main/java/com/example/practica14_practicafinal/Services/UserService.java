package com.example.practica14_practicafinal.Services;

import com.example.practica14_practicafinal.dao.UsersRepository;
import com.example.practica14_practicafinal.models.Users;
import com.example.practica14_practicafinal.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    JWTUtil jwtUtil;

    //Meotodo para listar todos los usarios de la BD
    public List<Users> getAllUsers(String token){
        if (validarToken(token)){
            return usersRepository.findAll();
        }else{
            return null;
        }
        //eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0IiwiaWF0IjoxNzM5NzYxMTQwLCJzdWIiOiJyb3NpbGxvb283OUBnbWFpbC5jb20iLCJpc3MiOiJNYWluIiwiZXhwIjoxNzQwMzY1OTQwfQ.ZENhIA542K_jlsHFoXZa0vVAPx6g0kVigztD32dztL8
    }

    public void deleteUserById(@PathVariable int id, String token){
        if (validarToken(token)){
            usersRepository.deleteById(id);
        }
    }

    public Users getUserById(@PathVariable int id, String token){
        Users usuario = usersRepository.findById(id).orElse(null);
        if (validarToken(token) && usuario != null){
            System.out.println("Usuario encontrado");
            return usuario;
        }else {
            System.out.println("Usuario no encontrado");
        }
        return null;
    }

    public void addUser(@RequestBody Users usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String password = usuario.getPassword();
        usuario.setPassword(argon2.hash(1, 1024, 1, password));

        usersRepository.save(usuario);
    }

    public boolean validarToken(String token){
        if (jwtUtil.getKey(token) != null){
            return true;
        }else {
            System.out.println("Sin autorizacion (Redirige al login)");
            return false;
        }
    }

}
