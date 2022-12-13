package com.rchf.contactos.app.dao;

import com.rchf.contactos.app.model.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactoDaoImpl implements ContactoDao {

    @Autowired
    private ContactoRepository agendaRepository;

    @Override
    public void agregarContacto(Contacto contacto) {
        agendaRepository.save(contacto);
    }

    @Override
    public Contacto recuperarContacto(String email) {
        return agendaRepository.findByEmail(email);
    }

    @Override
    public void eliminarContacto(String email) {
        agendaRepository.eliminarPorEmail(email);
    }

    @Override
    public List<Contacto> devolverContactos() {
        return agendaRepository.findAll();
    }

    @Override
    public void eliminarContacto(int idContacto) {
        agendaRepository.deleteById(idContacto);
    }

    @Override
    public Contacto recuperarContacto(int idContacto) {
        return agendaRepository.findById(idContacto).orElse(null);
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        agendaRepository.save(contacto);
    }
}
