package com.example.ImageGalery.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Coleccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColeccion;

    @Column(nullable = false, length = 254)
    private String nombre;

    @Column(nullable = false)
    private LocalDateTime fecha_creacion;

    @PrePersist
    protected void onCreate() {
        this.fecha_creacion = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonBackReference(value = "usuario-coleccion")
    private Usuario usuario;

    @OneToMany(mappedBy = "coleccion", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "coleccion-ref")
    private List<Coleccion_imagen> imagenesColeccion = new ArrayList<>();

    public Coleccion() {
    }

    public Coleccion(Long idColeccion, String nombre, LocalDateTime fecha_creacion, Usuario usuario, List<Coleccion_imagen> imagenesColeccion) {
        this.idColeccion = idColeccion;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.usuario = usuario;
        this.imagenesColeccion = imagenesColeccion;
    }

    public Long getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Long idColeccion) {
        this.idColeccion = idColeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public List<Coleccion_imagen> getImagenesColeccion() {
        return imagenesColeccion;
    }

    public void setImagenesColeccion(List<Coleccion_imagen> imagenesColeccion) {
        this.imagenesColeccion = imagenesColeccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
