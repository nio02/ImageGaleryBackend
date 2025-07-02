package com.example.ImageGalery.Service;

import com.example.ImageGalery.Model.Imagen;
import com.example.ImageGalery.Repository.IImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenService implements IImagenService {
    @Autowired
    private final IImagenRepository imagenRepository;

    @Autowired
    public ImagenService(IImagenRepository iImagenRepository) {
        this.imagenRepository = iImagenRepository;
    }

    @Override
    public List<Imagen> obtenerImagenes() {
        return imagenRepository.findAll();
    }

    @Override
    public Imagen obtenerImagen(Long id) {
        return imagenRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarImagen(Imagen imagen) {
        imagenRepository.save(imagen);
    }

    @Override
    public void editarImagen(Long id, Imagen imagen) {
        Imagen imagenExiste = imagenRepository.findById(id).orElse(null);

        if (imagenExiste != null){
            if (imagen.getDescripcion() != null){
                imagenExiste.setDescripcion(imagen.getDescripcion());
            }
            if (imagen.getUrl() != null){
                imagenExiste.setUrl(imagen.getUrl());
            }

            imagenRepository.save(imagenExiste);
        } else {
            throw new RuntimeException("Imagen no encontrada, id: " + id);
        }
    }

    @Override
    public void eliminarImagen(Long id) {
        imagenRepository.deleteById(id);
    }

    @Override
    public Imagen findByUrl(String url) {
        return imagenRepository.findByUrl(url);
    }
}
