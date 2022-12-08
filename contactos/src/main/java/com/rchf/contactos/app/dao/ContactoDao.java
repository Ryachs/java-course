package com.rchf.contactos.app.dao;

import com.rchf.contactos.app.model.Contacto;

import java.util.List;

public interface ContactoDao {
    void agregarContacto(Contacto contacto);

    Contacto recuperarContacto(String email);

    void eliminarContacto(String email);

    List<Contacto> devolverContactos();

    void eliminarContacto(int idContacto);

    Contacto recuperarContacto(int idContacto);

    void actualizarContacto(Contacto contacto);
}
