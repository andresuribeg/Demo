package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name = "uploads")
public class UploadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_archivo")
    private String nombreArchivo;

    // Agrega aquí los demás atributos necesarios según la estructura de tu tabla

    public UploadEntity() {
        // Constructor vacío necesario para JPA
    }

    // Agrega aquí los getters y setters de los atributos

}
