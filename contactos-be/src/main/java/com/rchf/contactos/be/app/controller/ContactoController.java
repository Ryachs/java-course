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
import java.util.stream.Collectors;

@RestController
public class ContactoController {

    @Autowired
    RestTemplate restTemplate;
    String url = "http://localhost:8080";

    @GetMapping(value = "/contacto/{nombre}/{edad}/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> saveContacto(@PathVariable("nombre") String nombre, @PathVariable("edad") int edad,
                                       @PathVariable("email") String email) {
        Contacto contacto = new Contacto(nombre, edad, email);
        restTemplate.postForLocation(url + "/save", contacto);
        Contacto[] contactos = restTemplate.getForObject(url + "/contactos", Contacto[].class);
        return Arrays.asList(contactos);
    }

    @GetMapping(path = "/contacto/{edad1}/edad/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto>buscarContacto(@PathVariable("edad1") int edad1, @PathVariable("edad2") int edad2) {
        Contacto[] contactos = restTemplate.getForObject(url + "/contactos", Contacto[].class);
        return Arrays.stream(contactos).filter(p->p.getEdad() >= edad1 && p.getEdad() <= edad2)
                .collect(Collectors.toList());
    }
}
