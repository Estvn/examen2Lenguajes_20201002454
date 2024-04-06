package hn.unah.lenguajes1900.data.examen2lenguajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cliente;
import hn.unah.lenguajes1900.data.examen2lenguajes.services.impls.ClienteServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {
    
    @Autowired
    ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/cliente/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return this.clienteServiceImpl.crearCliente(cliente);
    }

    @GetMapping("/cliente/obtenerClientes")
    public List<Cliente> obtenerClientes() {
        return this.clienteServiceImpl.obtenerClientes();
    }

    @GetMapping("/cliente/obtenerPorDni")
    public Cliente obtenerClientePorDni(String dni) {
        return this.clienteServiceImpl.obtenerClientePorDni(dni);
    }

}
