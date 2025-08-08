package com.example.ImageGalery.Service;

import com.example.ImageGalery.Model.Coleccion_imagen;
import com.example.ImageGalery.Repository.IColeccion_imagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Coleccion_imagenService implements IColeccion_imagenService {
    private final IColeccion_imagenRepository coleccionImagenRepository;

    @Autowired
    public Coleccion_imagenService(IColeccion_imagenRepository coleccionImagenRepository) {
        this.coleccionImagenRepository = coleccionImagenRepository;
    }

    @Override
    public Coleccion_imagen obtenerPorId(Long id) {
        return coleccionImagenRepository.findById(id).orElse(null);
    }

    @Override
    public List<Coleccion_imagen> obtenerTodos() {
        return coleccionImagenRepository.findAll();
    }
}
