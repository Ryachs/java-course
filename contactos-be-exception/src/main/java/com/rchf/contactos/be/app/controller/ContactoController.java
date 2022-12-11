package com.rchf.contactos.be.app.controller;


import com.rchf.contactos.be.app.entity.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContactoController {

    @Autowired
    RestTemplate restTemplate;
    String url = "http://localhost:8080";

    @GetMapping(value = "/contacto/{nombre}/{edad}/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contacto>> saveContacto(@PathVariable("nombre") String nombre,
                                                       @PathVariable("edad") int edad,
                                                       @PathVariable("email") String email) {
        Contacto contacto = new Contacto(nombre, edad, email);
        try {
            // Lanzamos la peticion mientras contenga un codigo distinto a 200
            // se producira la exception.
            restTemplate.postForLocation(url + "/save", contacto);
            // Si todo va OK devolvemos la respuesta OK
            Contacto[] contactos = restTemplate.getForObject(url + "/contactos", Contacto[].class);
            return new ResponseEntity<List<Contacto>>(Arrays.asList(contactos), HttpStatus.OK);
        } catch (HttpStatusCodeException e) {
            // El objeto HttpStatusCodeException nos entrega el codigo de estado y la respuesta
            HttpHeaders headers = new HttpHeaders();
            // Añadimos una cabecera de error con la respuesta del servicio ("El contacto ya existe")
            headers.add("ERROR", e.getResponseBodyAsString());
            // Aca le pasamos la lista vacia, el headers con el encabezado y el codigo de estado
            return new ResponseEntity<List<Contacto>>(new ArrayList<>(), headers, e.getStatusCode());
        }
    }

    @GetMapping(path = "/contacto/{edad1}/edad/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto>buscarContacto(@PathVariable("edad1") int edad1,
                                                        @PathVariable("edad2") int edad2) {
        Contacto[] contactos = restTemplate.getForObject(url + "/contactos", Contacto[].class);
        return Arrays.stream(contactos).filter(p->p.getEdad() >= edad1 && p.getEdad() <= edad2)
                .collect(Collectors.toList());
    }
}
