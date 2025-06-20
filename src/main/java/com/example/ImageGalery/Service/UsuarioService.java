package com.example.ImageGalery.Service;

import com.example.ImageGalery.Model.Usuario;
import com.example.ImageGalery.Repository.IusuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IusuarioService{
    private final IusuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(IusuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void editarUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);

        if(usuarioExistente != null){
            if (usuario.getNombreUsuario() != null){
                usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
            }
            if (usuario.getCorreo() != null){
                usuarioExistente.setCorreo(usuario.getCorreo());
            }
            if (usuario.getPassword() != null){
                usuarioExistente.setPassword(usuario.getPassword());
            }

            usuarioRepository.save(usuarioExistente);
        } else {
            throw new RuntimeException("Usuario no encontrado con el id: " + id);
        }
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findbyCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public Usuario findbyUsername(String username) {
        return usuarioRepository.findByNombreUsuario(username);
    }
}
