package com.example.ImageGalery.Controller;

import com.example.ImageGalery.Model.Coleccion;
import com.example.ImageGalery.Service.IColeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colections")
public class ColeccionController {
    @Autowired
    private final IColeccionService coleccionService;

    @Autowired
    public ColeccionController(IColeccionService coleccionService) {
        this.coleccionService = coleccionService;
    }

    @GetMapping
    public List<Coleccion> listaColecciones(){
        return coleccionService.obtenerTodos();
    }

    @PostMapping("/save")
    public ResponseEntity<String> guardarColeccion(@RequestBody Coleccion coleccion){
        try{
            coleccionService.guardarColeccion(coleccion);
        } catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
        }
    }
}
