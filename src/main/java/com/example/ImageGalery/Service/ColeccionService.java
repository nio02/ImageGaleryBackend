package com.example.ImageGalery.Service;

import com.example.ImageGalery.Dto.ColeccionDto;
import com.example.ImageGalery.Model.Coleccion;
import com.example.ImageGalery.Model.Imagen;
import com.example.ImageGalery.Repository.IColeccionRepository;
import com.example.ImageGalery.Repository.IImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColeccionService implements IColeccionService{
    private final IColeccionRepository coleccionRepository;

    @Autowired
    public ColeccionService(IColeccionRepository coleccionRepository) {
        this.coleccionRepository = coleccionRepository;
    }

    @Override
    public List<Coleccion> obtenerTodos() {
        return coleccionRepository.findAll();
    }

    @Override
    public Coleccion obtenerPorId(Long id) {
        return coleccionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Coleccion> obtenerColeccionesUsuario(Long idUsuario) {
        return coleccionRepository.findByUsuarioId(idUsuario);
    }

    @Override
    public void guardarColeccion(Coleccion coleccion) {
        coleccionRepository.save(coleccion);
    }

    @Override
    public void eliminarColeccion(Long id) {
        coleccionRepository.deleteById(id);
    }

    @Override
    public void actualizarColeccion(Long id, ColeccionDto coleccionDto) {
        Coleccion coleccionExiste = coleccionRepository.findById(id).orElse(null);

        if(coleccionExiste != null){
            coleccionExiste.setNombre(coleccionDto.getNombre());

            coleccionRepository.save(coleccionExiste);
        } else {
            throw new RuntimeException("Coleccion no encontrada con el id: " + id);
        }
    }

}
