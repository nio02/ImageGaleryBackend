package com.example.ImageGalery.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    //Atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(nullable = false)
    private String nombreUsuario;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String password;

    //Relaciones
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "usuario-imagen")
    private List<Imagen> imagenes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "usuario-coleccion")
    private List<Coleccion> coleccion = new ArrayList<>();

    //Constructores
    public Usuario() {
    }

    public Usuario(Long id_usuario, String nombreUsuario, String correo, String password, List<Imagen> imagenes) {
        this.id = id_usuario;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.password = password;
        this.imagenes = imagenes;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id_usuario) {
        this.id = id_usuario;
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

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
}
