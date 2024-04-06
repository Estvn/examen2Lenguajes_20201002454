package hn.unah.lenguajes1900.data.examen2lenguajes.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Direccion;
import hn.unah.lenguajes1900.data.examen2lenguajes.repositories.ClienteRepository;
import hn.unah.lenguajes1900.data.examen2lenguajes.repositories.DireccionRepository;
import hn.unah.lenguajes1900.data.examen2lenguajes.services.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    DireccionRepository direccionRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Direccion crearDireccion(Direccion direccion, String dni) {
        
        if(this.clienteRepository.existsById(direccion.getCliente().getDni())){

            this.clienteRepository.findById(dni).get().setDireccion(direccion);
            return this.direccionRepository.save(direccion);
        }
        return null;
    }
    
}
