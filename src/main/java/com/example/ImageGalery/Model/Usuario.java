package com.example.ImageGalery.Model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    //Atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false)
    private String nombreUsuario;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String direccion;

    //Constructores
    public Usuario() {
    }

    public Usuario(Long id_usuario, String nombreUsuario, String correo, String password, String direccion) {
        this.id_usuario = id_usuario;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.password = password;
        this.direccion = direccion;
    }

    //Getters y Setters
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
