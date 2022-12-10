package com.rchf.contactos.be.app.service;

import com.rchf.contactos.be.app.entity.Contacto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AccesoService {
    CompletableFuture<List<Contacto>>  llamadaServicio(Contacto contacto);
}
