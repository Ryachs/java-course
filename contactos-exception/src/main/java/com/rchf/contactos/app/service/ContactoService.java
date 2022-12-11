package com.rchf.contactos.app.service;

import com.rchf.contactos.app.model.Contacto;

import java.util.List;

public interface ContactoService {
    boolean agregarContacto(Contacto contacto) throws Exception;
    List<Contacto> recuperarContactos();
    void actualizarContacto(Contacto contacto);
    boolean eliminarCotacto(int idContacto);
    Contacto buscarContacto(int idContacto);
}
