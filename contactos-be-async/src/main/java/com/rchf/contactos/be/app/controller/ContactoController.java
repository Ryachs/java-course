package com.rchf.contactos.be.app.controller;


import com.rchf.contactos.be.app.entity.Contacto;
import com.rchf.contactos.be.app.service.AccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class ContactoController {

    protected static Logger logger = (Logger) LoggerFactory.getLogger(ContactoController.class);

    @Autowired
    private AccesoService accesoService;

    @GetMapping(value = "/contacto/{nombre}/{edad}/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> saveContacto(@PathVariable("nombre") String nombre, @PathVariable("edad") int edad,
                                       @PathVariable("email") String email) {
        Contacto contacto = new Contacto(nombre, edad, email);
        CompletableFuture<List<Contacto>> contactos = accesoService.llamadaServicio(contacto);
        for(int i = 1; i < 40; i++) {
            logger.info("Esperando para probar ASYNG");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        try {
            return contactos.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }
}
