package hn.unah.lenguajes1900.data.examen2lenguajes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cuenta;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, String>{
    
}
