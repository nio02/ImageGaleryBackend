package com.example.ImageGalery.Service;

import com.example.ImageGalery.Dto.ColeccionDto;
import com.example.ImageGalery.Model.Coleccion;

import java.util.List;

public interface IColeccionService {
    List<Coleccion> obtenerTodos();
    Coleccion obtenerPorId(Long id);
    List<Coleccion> obtenerColeccionesUsuario(Long idUsuario);
    void guardarColeccion(Coleccion coleccion);
    void agregarImagen(Long idColeccion, Long idImagen);
    void eliminarColeccion(Long id);
    void actualizarColeccion(Long id, ColeccionDto coleccionDto);
    void eliminarImagenColeccion(Long idColeccion, Long idImagen);
}
