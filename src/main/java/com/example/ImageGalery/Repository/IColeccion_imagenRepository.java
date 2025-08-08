package com.example.ImageGalery.Repository;

import com.example.ImageGalery.Model.Coleccion_imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColeccion_imagenRepository extends JpaRepository<Coleccion_imagen, Long> {
}
