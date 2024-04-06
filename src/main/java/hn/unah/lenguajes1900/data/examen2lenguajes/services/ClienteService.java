package hn.unah.lenguajes1900.data.examen2lenguajes.services;

import java.util.List;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cliente;

public interface ClienteService {
    
    public Cliente crearCliente(Cliente cliente);

    public List<Cliente> obtenerClientes();

    public Cliente obtenerClientePorDni(String dni);
}
