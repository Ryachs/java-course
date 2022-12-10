package com.rchf.contactos.app.controller;

import com.rchf.contactos.app.model.Contacto;
import com.rchf.contactos.app.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ContactosController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping(value = "/contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> recuperarContactos() {
        // Detenemos el hilo por 8 segundos
        // Para Probar el metodo ASYNC
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return contactoService.recuperarContactos();
    }

    @GetMapping(value = "/contacto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contacto recuperarContacto(@PathVariable("id") int id) {
        return contactoService.buscarContacto(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String guardarContacto(@RequestBody Contacto contacto) {
        return String.valueOf(contactoService.agregarContacto(contacto));
    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void ActualizarContacto(@RequestBody Contacto contacto) {
        contactoService.actualizarContacto(contacto);
    }

    @DeleteMapping("/eliminar/{id}")
    public  void eliminarById(@PathVariable("id") int idContacto) {
        contactoService.eliminarCotacto(idContacto);
    }
}
