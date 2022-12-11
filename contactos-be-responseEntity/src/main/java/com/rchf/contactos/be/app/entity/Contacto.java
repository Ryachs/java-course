package com.rchf.contactos.be.app.entity;

import lombok.Data;

@Data
public class Contacto {
    private String nombre;
    private int edad;
    private String email;

    public Contacto(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public Contacto() {
    }
}
