package com.example.ImageGalery.Repository;

import com.example.ImageGalery.Model.Coleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IColeccionRepository extends JpaRepository<Coleccion, Long> {
    List<Coleccion> findByUsuarioId(Long id);
}
