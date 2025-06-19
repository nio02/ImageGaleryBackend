package com.example.ImageGalery.Model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    //Atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String password;


}
