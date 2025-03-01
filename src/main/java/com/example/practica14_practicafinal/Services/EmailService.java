package com.example.practica14_practicafinal.Services;


import com.example.practica14_practicafinal.dao.EmailRepository;
import com.example.practica14_practicafinal.models.CodigoVerficacion;
import com.example.practica14_practicafinal.models.EmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javamailSender; // java mailSender se usa para enviar correos en srping boot
    @Autowired
    private TemplateEngine templateEngine; // se usa para generar contenido html dinamico en los correos
    @Autowired
    private EmailRepository emailRepository;


    public void sendEmail( EmailDTO gmail) throws MessagingException {
        try {
            String CodigoVerificacion = generarCodigo();

            // Guardar el código en la base de datos
            CodigoVerficacion nuevoCodigo = new CodigoVerficacion();

            System.out.println("gmail dest: "+gmail.getDestinatario());
            nuevoCodigo.setGmail(gmail.getDestinatario());
            nuevoCodigo.setCodigo(CodigoVerificacion);
            nuevoCodigo.setFecha_creacion(LocalDateTime.now());
            nuevoCodigo.setFecha_expiracion(LocalDateTime.now().plusMinutes(10));  // Código válido por 10 minutos
            emailRepository.save(nuevoCodigo);

            // Resto del código para enviar el correo
            MimeMessage message = javamailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF8");

            helper.setTo(gmail.getDestinatario());
            helper.setSubject(gmail.getAsunto());

            Context context = new Context();
            context.setVariable("mensaje", "Tu codigo de verificacion es: " + CodigoVerificacion);
            gmail.setCodigoVerificacion(CodigoVerificacion);
            String contentHTML = templateEngine.process("email", context);

            helper.setText(contentHTML, true);

            javamailSender.send(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Boolean verifyCodEmail(String codigo, String gmail) {
        // Buscar el código en la base de datos
        System.out.println(codigo);
        System.out.println(gmail);
        CodigoVerficacion codigoVerificacion = emailRepository.findByCodigoAndGmail(codigo, gmail);

        if (codigoVerificacion != null) {
            // Verificar si el código ha expirado
            if (codigoVerificacion.getFecha_expiracion().isAfter(LocalDateTime.now())) {
                System.out.println("Código de verificación correcto");
                emailRepository.delete(codigoVerificacion);
                return true;

            } else {
                System.out.println("El código ha expirado");
            }
        }

        System.out.println("Código de verificación incorrecto");
        return false;
    }

    private String generarCodigo() {
        SecureRandom random = new SecureRandom();
        int codigo = 100000 + random.nextInt(900000); // Genera un número entre 100000 y 999999
        return String.valueOf(codigo);
    }

}
