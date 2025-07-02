package com.example.ImageGalery.Controller;

import com.example.ImageGalery.Model.Imagen;
import com.example.ImageGalery.Model.Usuario;
import com.example.ImageGalery.Service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private final ImagenService imagenService;

    @Autowired
    public ImageController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @GetMapping
    public List<Imagen> listaImagenes(){
        return imagenService.obtenerImagenes();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> guardarImagen(@RequestBody Imagen imagen){
        imagenService.guardarImagen(imagen);
        return ResponseEntity.ok("Imagen cargada con éxito");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarImagen(@PathVariable Long id){
        imagenService.eliminarImagen(id);
        return ResponseEntity.ok("Imagen eliminada con éxito");
    }

}
