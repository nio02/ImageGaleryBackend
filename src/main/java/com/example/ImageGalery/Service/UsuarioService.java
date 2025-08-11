package com.example.ImageGalery.Service;

import com.example.ImageGalery.Model.Usuario;
import com.example.ImageGalery.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private final IUsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(IUsuarioRepository usuarioRepository) {
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
                if(passwordEncoder.matches(usuario.getPassword(), usuarioExistente.getPassword())){
                    throw new RuntimeException("La contraseña no es válida");
                }
                usuarioExistente.setPassword(passwordEncoder.encode(usuario.getPassword()));
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
    public void registrarUsuario(Usuario usuario) {
        //Validacion Usuario Existente
        Usuario usuarioExistente = usuarioRepository.findByCorreo(usuario.getCorreo());
        Usuario userNameExiste = usuarioRepository.findByNombreUsuario(usuario.getNombreUsuario());
        if (usuarioExistente != null){
            throw new IllegalArgumentException("El correo ya está registrado");
        } else if (userNameExiste != null) {
            throw new IllegalArgumentException("El nombre de usuario ya está registrado");
        }

        //Registro nuevo usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCorreo(usuario.getCorreo());
        nuevoUsuario.setNombreUsuario(usuario.getNombreUsuario());
        nuevoUsuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(nuevoUsuario);
    }

    @Override
    public Usuario findbyCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public Usuario findbyUsername(String username) {
        Usuario usuarioEncontrado = usuarioRepository.findByNombreUsuario(username);

        if (usuarioEncontrado != null){
            return usuarioRepository.findByNombreUsuario(username);
        } else {
            throw new IllegalArgumentException("El nombre de usuario no fue encontrado!.");
        }
    }

    // Métdo de carga de usuario implementado desde UserDetailsService
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new org.springframework.security.core.userdetails.User(usuario.getNombreUsuario(), usuario.getPassword(), new ArrayList<>());
    }
}
