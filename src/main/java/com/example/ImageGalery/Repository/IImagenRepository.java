package com.example.ImageGalery.Repository;

import com.example.ImageGalery.Model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagenRepository extends JpaRepository<Imagen, Long> {
    Imagen findByUrl(String url);
}
