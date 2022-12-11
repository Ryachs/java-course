package com.rchf.contactos.be.app.controller;


import com.rchf.contactos.be.app.entity.Contacto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
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
        try {
            ResponseEntity<Void> response = restTemplate.postForEntity(url + "/save", contacto, Void.class);
            HttpHeaders headers = response.getHeaders();
            int total = Integer.parseInt(headers.get("Total").get(0));
            if (total == 0) {
                return null;
            }

            ResponseEntity<Contacto[]> contactos = restTemplate.getForEntity(url + "/contactos", Contacto[].class);

            // getBody() nos devuelve la respuesta completa
            return Arrays.asList(contactos.getBody());
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping(path = "/contacto/{edad1}/edad/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto>buscarContacto(@PathVariable("edad1") int edad1, @PathVariable("edad2") int edad2) {
        ResponseEntity<Contacto[]> contactos = restTemplate.getForEntity(url + "/contactos", Contacto[].class);
        return Arrays.stream(contactos.getBody()).filter(p->p.getEdad() >= edad1 && p.getEdad() <= edad2)
                .collect(Collectors.toList());
    }
}
