package com.example.ImageGalery.Controller;

import com.example.ImageGalery.Dto.ColeccionDto;
import com.example.ImageGalery.Model.Coleccion;
import com.example.ImageGalery.Service.ColeccionService;
import com.example.ImageGalery.Service.Coleccion_imagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class ColeccionController {
    private final ColeccionService coleccionService;

    private final Coleccion_imagenService coleccionImagenService;

    @Autowired
    public ColeccionController(ColeccionService coleccionService, Coleccion_imagenService coleccionImagenService) {
        this.coleccionService = coleccionService;
        this.coleccionImagenService = coleccionImagenService;
    }

    @GetMapping
    public List<Coleccion> listaColecciones(){
        return coleccionService.obtenerTodos();
    }

    @GetMapping("/user/{id}")
    public List<Coleccion> listaColeccionesUsuario(@PathVariable Long id){
        return coleccionService.obtenerColeccionesUsuario(id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> guardarColeccion(@RequestBody Coleccion coleccion){
        try{
            coleccionService.guardarColeccion(coleccion);
            return ResponseEntity.ok("Coleccion agregada con éxito!");
        } catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
        }
    }

    @PostMapping("/save/image/{idImagen}/collection/{idColeccion}")
    public ResponseEntity<String> agregarImagenColeccion(@PathVariable Long idImagen, @PathVariable Long idColeccion){
        try{
            coleccionImagenService.agregarImagenAColeccion(idImagen, idColeccion);
            return ResponseEntity.ok("Imagen agregada a coleccion");
        } catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editarColeccion(@PathVariable Long id, @RequestBody ColeccionDto coleccion){
        try{
            coleccionService.actualizarColeccion(id, coleccion);
            return ResponseEntity.ok("Coleccion actualizada exitosamente");
        } catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/collection/{id}")
    public ResponseEntity<String> eliminarColeccion(@PathVariable Long id){
        try{
            coleccionService.eliminarColeccion(id);
            return ResponseEntity.ok("La coleccion ha sido eliminada exitosamente");
        }catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/image/{idImagen}/collection/{idColeccion}")
    public ResponseEntity<String> eliminarImagenDeColeccion(@PathVariable Long idColeccion, @PathVariable Long idImagen){
        try{
            coleccionService.eliminarImagenColeccion(idColeccion, idImagen);
            return ResponseEntity.ok("Imagen eliminada de la coleccion");
        } catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
        }
    }

}
