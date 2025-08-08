package com.example.ImageGalery.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "imagen_coleccion")
public class Coleccion_imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coleccion_imagen")
    private Long id_coleccion_imagen;

    @Column(nullable = false)
    private LocalDateTime fecha_agregada;

    @PrePersist
    protected void onCreate() {
        this.fecha_agregada = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "id_coleccion", nullable = false)
    @JsonBackReference(value = "coleccion-ref")
    private Coleccion coleccion;

    @ManyToOne
    @JoinColumn(name = "id_imagen", nullable = false)
    @JsonBackReference(value = "imagen-ref")
    private Imagen imagen;

    public Coleccion_imagen() {
    }

    public Coleccion_imagen(Long id_coleccion_imagen, LocalDateTime fecha_agregada, Coleccion coleccion, Imagen imagen) {
        this.id_coleccion_imagen = id_coleccion_imagen;
        this.fecha_agregada = fecha_agregada;
        this.coleccion = coleccion;
        this.imagen = imagen;
    }

    public Long getId_coleccion_imagen() {
        return id_coleccion_imagen;
    }

    public void setId_coleccion_imagen(Long id_coleccion_imagen) {
        this.id_coleccion_imagen = id_coleccion_imagen;
    }

    public Coleccion getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public LocalDateTime getFecha_agregada() {
        return fecha_agregada;
    }

    public void setFecha_agregada(LocalDateTime fecha_agregada) {
        this.fecha_agregada = fecha_agregada;
    }
}
