package com.example.ImageGalery.Repository;

import com.example.ImageGalery.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IusuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreo(String correo);
    Usuario findByNombreUsuario(String username);
}
