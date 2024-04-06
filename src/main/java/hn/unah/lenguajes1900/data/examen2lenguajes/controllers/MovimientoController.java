package hn.unah.lenguajes1900.data.examen2lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cuenta;
import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Movimiento;
import hn.unah.lenguajes1900.data.examen2lenguajes.services.impls.MovimientoServiceImpl;

@RestController
@RequestMapping("/api")
public class MovimientoController {

    @Autowired
    MovimientoServiceImpl movimientoServiceImpl;
    
    @PostMapping("/mocimiento/crear")
    public Movimiento crearMovimiento(Movimiento movimiento) {
        return this.movimientoServiceImpl.crearMovimiento(movimiento);
    }

    @GetMapping("/movimiento/obtener")
    public Cuenta obtenerMovimientoPorCuenta(String numeroCuenta) {
        return this.movimientoServiceImpl.obtenerMovimientoPorCuenta(numeroCuenta);
    }
}
