package com.rchf.contactos.app.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contactos")
@NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContacto;
    private String nombre;
    private int edad;
    private String email;

}
