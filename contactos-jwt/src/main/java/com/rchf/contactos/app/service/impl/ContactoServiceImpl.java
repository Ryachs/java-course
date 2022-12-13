package com.rchf.contactos.app.service.impl;

import com.rchf.contactos.app.model.Contacto;
import com.rchf.contactos.app.dao.ContactoDao;
import com.rchf.contactos.app.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoDao contactoDao;

    @Override
    public boolean agregarContacto(Contacto contacto) {
        if(contactoDao.recuperarContacto(contacto.getIdContacto()) == null) {
            contactoDao.agregarContacto(contacto);
            return true;
        }
        return false;
    }

    @Override
    public List<Contacto> recuperarContactos() {
        return contactoDao.devolverContactos();
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        if(contactoDao.recuperarContacto(contacto.getIdContacto()) != null) {
            contactoDao.actualizarContacto(contacto);
        }
    }

    @Override
    public boolean eliminarCotacto(int idContacto) {
        if(contactoDao.recuperarContacto(idContacto) != null) {
            contactoDao.eliminarContacto(idContacto);
        }
        return false;
    }

    @Override
    public Contacto buscarContacto(int idContacto) {
        return contactoDao.recuperarContacto(idContacto);
    }
}
