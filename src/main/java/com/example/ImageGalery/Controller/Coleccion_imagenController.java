package com.example.ImageGalery.Controller;

import com.example.ImageGalery.Model.Coleccion_imagen;
import com.example.ImageGalery.Service.IColeccion_imagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collection-image")
public class Coleccion_imagenController {
    private final IColeccion_imagenService coleccionImagenService;

    @Autowired
    public Coleccion_imagenController(IColeccion_imagenService coleccionImagenService) {
        this.coleccionImagenService = coleccionImagenService;
    }

    @GetMapping
    public List<Coleccion_imagen> obtenerTodos(){
        return coleccionImagenService.obtenerTodos();
    }

    @DeleteMapping("/delete/image/{idImagen}/collection/{idColeccion}")
    public ResponseEntity<String> eliminarImagenDeColeccion(@PathVariable Long idColeccion, @PathVariable Long idImagen){
        try{
            coleccionImagenService.eliminarImagenDeColeccion(idColeccion, idImagen);
            return ResponseEntity.ok("La imagen ha sido eliminada de la coleccion exitosamente");
        } catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
        }
    }
}
