package hn.unah.lenguajes1900.data.examen2lenguajes.services;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cuenta;
import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Movimiento;

public interface MovimientoService {

    public Movimiento crearMovimiento(Movimiento Movimiento);

    public Cuenta obtenerMovimientoPorCuenta(String numeroCuenta);
    
}
