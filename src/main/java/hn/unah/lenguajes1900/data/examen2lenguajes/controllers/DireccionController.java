package hn.unah.lenguajes1900.data.examen2lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Direccion;
import hn.unah.lenguajes1900.data.examen2lenguajes.services.impls.DireccionServiceImpl;

@RestController
@RequestMapping("/api")
public class DireccionController {
    
    @Autowired
    DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/direccion/crear/{dni}")
    public Direccion crearDireccion(@RequestBody Direccion direccion,@PathVariable String dni) {
        return this.direccionServiceImpl.crearDireccion(direccion, dni);
    }
    
}
