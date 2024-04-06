package hn.unah.lenguajes1900.data.examen2lenguajes.services;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cliente;
import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cuenta;

public interface CuentaService {

    public Cuenta crearCuenta(Cuenta cuenta);

    public Cliente asociarCuentaCliente(String dni, String numeroCuenta);
    
}
