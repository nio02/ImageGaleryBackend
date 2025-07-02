package com.example.ImageGalery.Service;

import com.example.ImageGalery.Model.Imagen;

import java.util.List;

public interface IImagenService {
    List<Imagen> obtenerImagenes();
    Imagen obtenerImagen(Long id);
    void guardarImagen(Imagen imagen);
    void editarImagen(Long id, Imagen imagen);
    void eliminarImagen(Long id);
    Imagen findByUrl(String url);

}
