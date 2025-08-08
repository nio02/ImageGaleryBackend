package com.example.ImageGalery.Controller;

import com.example.ImageGalery.Model.Coleccion_imagen;
import com.example.ImageGalery.Service.IColeccion_imagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
