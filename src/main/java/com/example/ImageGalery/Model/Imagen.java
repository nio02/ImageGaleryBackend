package com.example.ImageGalery.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Imagen {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_imagen;

    @Column(nullable = false, length = 254)
    private String descripcion;

    @Column(nullable = false, length = 100)
    private String url;

    @Column(nullable = false)
    private LocalDateTime fecha_subida;

    @PrePersist
    protected void onCreate() {
        this.fecha_subida = LocalDateTime.now();
    }

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonBackReference(value = "usuario-imagen")
    private Usuario usuario;

    //Constructores

    public Imagen() {
    }

    public Imagen(Long id_imagen, String descripcion, String url, LocalDateTime fecha_subida, Usuario usuario) {
        this.id_imagen = id_imagen;
        this.descripcion = descripcion;
        this.url = url;
        this.fecha_subida = fecha_subida;
        this.usuario = usuario;
    }

    //Getters y Setters

    public Long getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(Long id_imagen) {
        this.id_imagen = id_imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getFecha_subida() {
        return fecha_subida;
    }

    public void setFecha_subida(LocalDateTime fecha_subida) {
        this.fecha_subida = fecha_subida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
