package com.example.ImageGalery.Service;

import com.example.ImageGalery.Model.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> obtenerUsuarios();
    Usuario obtenerUsuario(Long id);
    void guardarUsuario(Usuario usuario);
    void editarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
    void registrarUsuario(Usuario usuario);
    Usuario findbyCorreo(String correo);
    Usuario findbyUsername(String username);
}
