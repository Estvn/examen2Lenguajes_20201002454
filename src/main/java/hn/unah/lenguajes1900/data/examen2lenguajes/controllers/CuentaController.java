package hn.unah.lenguajes1900.data.examen2lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cliente;
import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cuenta;
import hn.unah.lenguajes1900.data.examen2lenguajes.services.impls.CuentaServiceImpl;

@RestController
@RequestMapping("/api")
public class CuentaController {
    
    @Autowired
    CuentaServiceImpl cuentaServiceImpl;

    @PostMapping("/cuenta/crear")
    public Cuenta crearCuenta(Cuenta cuenta) {
        return this.cuentaServiceImpl.crearCuenta(cuenta);
        
    }

    @PutMapping("/cuenta/asociar")
    public Cliente asociarCuentaCliente(String dni, String numeroCuenta) {
        return this.cuentaServiceImpl.asociarCuentaCliente(dni, numeroCuenta);
    
    }
    
}
