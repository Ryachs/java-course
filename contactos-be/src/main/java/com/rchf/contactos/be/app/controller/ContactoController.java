package com.rchf.contactos.be.app.controller;


import com.rchf.contactos.be.app.entity.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ContactoController {

    @Autowired
    RestTemplate restTemplate;
    String url = "http://localhost:8080";

    @GetMapping(value = "/contacto/{nombre}/{edad}/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> saveContacto(@PathVariable("nombre") String nombre, @PathVariable("edad") int edad,
                                       @PathVariable("email") String email) {
        Contacto contacto = new Contacto(nombre, edad, email);
        restTemplate.postForLocation(url, "/save", contacto);
        Contacto[] contactos = restTemplate.getForObject(url + "/contactos", Contacto[].class);
        return Arrays.asList(contactos);
    }
}
