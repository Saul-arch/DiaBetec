package com.example.practica14_practicafinal.controllers;

import com.example.practica14_practicafinal.Services.EmailService;
import com.example.practica14_practicafinal.models.EmailDTO;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sendemail")
public class EmailController {
    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/sendcod", method = RequestMethod.POST)
    public void sendMesage(@RequestBody EmailDTO emailDTO) throws MessagingException {
        emailDTO.setAsunto("Registro usuario");
        emailDTO.setDestinatario(emailDTO.getDestinatario());

        emailService.sendEmail(emailDTO);
        System.out.println("el gmail destino es: "+emailDTO.getDestinatario());
    }

    @RequestMapping(value = "/verifyCod", method = RequestMethod.POST)
    public boolean verificarCod(@RequestBody EmailDTO emailDTO) throws MessagingException {
        System.out.println(emailDTO.getDestinatario());
        System.out.println(emailDTO.getCodigoVerificacion());
        return emailService.verifyCodEmail(emailDTO.getCodigoVerificacion(), emailDTO.getDestinatario());

    }

}
