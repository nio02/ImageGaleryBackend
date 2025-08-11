package com.example.ImageGalery.Service;

import com.example.ImageGalery.Model.Coleccion_imagen;

import java.util.List;

public interface IColeccion_imagenService {
    Coleccion_imagen obtenerPorId(Long id);
    List<Coleccion_imagen> obtenerTodos();
    void agregarImagenAColeccion(Long idImagen, Long idColeccion);
    void eliminarImagenDeColeccion(Long idImagen, Long idColeccion);
}
