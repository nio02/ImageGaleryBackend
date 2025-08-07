package com.example.ImageGalery.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Coleccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coleccion;

    @Column(nullable = false, length = 254)
    private String nombre;

    @Column(nullable = false)
    private LocalDateTime fecha_creacion;

    @PrePersist
    protected void onCreate() {
        this.fecha_creacion = LocalDateTime.now();
    }

    @ManyToMany
    @JoinTable(
            name = "coleccion_imagen",
            joinColumns = @JoinColumn(name = "id_coleccion"),
            inverseJoinColumns = @JoinColumn(name = "id_imagen")
    )


    @JsonManagedReference(value = "coleccion-imagen")
    private List<Imagen> imagenesColeccion = new ArrayList<>();

    public Coleccion() {
    }

    public Coleccion(Long id_coleccion, String nombre, LocalDateTime fecha_creacion) {
        this.id_coleccion = id_coleccion;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
    }

    public Long getId_coleccion() {
        return id_coleccion;
    }

    public void setId_coleccion(Long id_coleccion) {
        this.id_coleccion = id_coleccion;
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

    public List<Imagen> getImagenesColeccion() {
        return imagenesColeccion;
    }

    public void setImagenesColeccion(List<Imagen> imagenesColeccion) {
        this.imagenesColeccion = imagenesColeccion;
    }
}
