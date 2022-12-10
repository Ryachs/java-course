package com.rchf.contactos.be.app.service.impl;

import com.rchf.contactos.be.app.entity.Contacto;
import com.rchf.contactos.be.app.service.AccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AccesoServiceImpl implements AccesoService {

    @Autowired
    RestTemplate restTemplate;
    String url = "http://localhost:8080";

    @Async
    public CompletableFuture<List<Contacto>> llamadaServicio(Contacto contacto) {
        restTemplate.postForLocation(url + "/save", contacto);
        Contacto[] contactos = restTemplate.getForObject(url + "/contactos", Contacto[].class);
        return CompletableFuture.completedFuture(Arrays.asList(contactos));
    }
}
