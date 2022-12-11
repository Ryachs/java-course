package com.rchf.contactos.app.controller;

import com.rchf.contactos.app.model.Contacto;
import com.rchf.contactos.app.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ContactosController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping(value = "/contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contacto>> recuperarContactos() {
        List<Contacto> contactos = contactoService.recuperarContactos();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total", String.valueOf(contactos.size()));
        return new ResponseEntity<List<Contacto>>(contactos, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/contacto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contacto> recuperarContacto(@PathVariable("id") int id) {
        Contacto contactos = contactoService.buscarContacto(id);
        return new ResponseEntity<Contacto>(contactos, HttpStatus.OK);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> guardarContacto(@RequestBody Contacto contacto) {
        if (contactoService.agregarContacto(contacto)) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> ActualizarContacto(@RequestBody Contacto contacto) {
        contactoService.actualizarContacto(contacto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarById(@PathVariable("id") int idContacto) {
        contactoService.eliminarCotacto(idContacto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
