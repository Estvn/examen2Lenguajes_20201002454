package hn.unah.lenguajes1900.data.examen2lenguajes.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cliente;
import hn.unah.lenguajes1900.data.examen2lenguajes.repositories.ClienteRepository;
import hn.unah.lenguajes1900.data.examen2lenguajes.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        
        if(!this.clienteRepository.existsById(cliente.getDni())){

            return this.clienteRepository.save(cliente);
        }

        return null;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerClientePorDni(String dni) {
        
        if(this.clienteRepository.existsById(dni)){

            return this.clienteRepository.findById(dni).get();
        }

        return null;
    }


    
}
