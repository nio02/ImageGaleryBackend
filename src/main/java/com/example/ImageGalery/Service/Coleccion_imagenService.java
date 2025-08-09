package com.example.ImageGalery.Service;

import com.example.ImageGalery.Model.Coleccion;
import com.example.ImageGalery.Model.Coleccion_imagen;
import com.example.ImageGalery.Model.Imagen;
import com.example.ImageGalery.Repository.IColeccionRepository;
import com.example.ImageGalery.Repository.IColeccion_imagenRepository;
import com.example.ImageGalery.Repository.IImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Coleccion_imagenService implements IColeccion_imagenService {
    private final IColeccion_imagenRepository coleccionImagenRepository;

    private final IColeccionRepository coleccionRepository;

    private final IImagenRepository imagenRepository;

    @Autowired
    public Coleccion_imagenService(IColeccion_imagenRepository coleccionImagenRepository, IColeccionRepository coleccionRepository, IImagenRepository imagenRepository) {
        this.coleccionImagenRepository = coleccionImagenRepository;
        this.coleccionRepository = coleccionRepository;
        this.imagenRepository = imagenRepository;
    }

    @Override
    public Coleccion_imagen obtenerPorId(Long id) {
        return coleccionImagenRepository.findById(id).orElse(null);
    }

    @Override
    public List<Coleccion_imagen> obtenerTodos() {
        return coleccionImagenRepository.findAll();
    }

    @Override
    public void agregarImagenAColeccion(Long idImagen, Long idColeccion) {
        Coleccion coleccion = coleccionRepository.findById(idColeccion).orElseThrow(() -> new RuntimeException("Coleccion no encontrada"));
        Imagen imagen = imagenRepository.findById(idImagen).orElseThrow(() -> new RuntimeException("Imagen no encontrada"));

        Coleccion_imagen coleccion_imagen = new Coleccion_imagen();
        coleccion_imagen.setColeccion(coleccion);
        coleccion_imagen.setImagen(imagen);

        coleccionImagenRepository.save(coleccion_imagen);
    }
}
