package com.example.ImageGalery.Controller;

import com.example.ImageGalery.JwtUtil;
import com.example.ImageGalery.Model.Usuario;
import com.example.ImageGalery.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listaUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable Long id){
        return usuarioService.obtenerUsuario(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok("Usuario agregado con éxito!");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario){
        usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok("Usuario agregado con éxito!");
    }

//    @PostMapping("/login")
//    public ResponseEntity<String>

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> editarUsuario(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado con éxtio!");
    }
}
