package hn.unah.lenguajes1900.data.examen2lenguajes.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cuenta;
import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Movimiento;
import hn.unah.lenguajes1900.data.examen2lenguajes.repositories.CuentaRepository;
import hn.unah.lenguajes1900.data.examen2lenguajes.repositories.MovimientoRepository;
import hn.unah.lenguajes1900.data.examen2lenguajes.services.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService{

    @Autowired
    MovimientoRepository movimientoRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    public Movimiento crearMovimiento(Movimiento movimiento) {
        
        if(this.cuentaRepository.existsById(movimiento.getCuenta().getNumeroCuenta()) &&
        this.cuentaRepository.findById(movimiento.getCuenta().getNumeroCuenta()).get().isEstado() == true){

            char valor = movimiento.getTipoMovimiento();
            if(valor == 'C' || valor == 'D'){

                double saldo = this.cuentaRepository.findById(movimiento.getCuenta().getNumeroCuenta()).get().getSaldo();

                if(valor == 'C'){

                    this.cuentaRepository.findById(movimiento.getCuenta().getNumeroCuenta()).get().setSaldo(saldo + movimiento.getMonto());
                    
                }
                this.cuentaRepository.findById(movimiento.getCuenta().getNumeroCuenta()).get().setSaldo(saldo - movimiento.getMonto());
            }

            return this.movimientoRepository.save(movimiento);
        }

        return null;
    }

    @Override
    public Cuenta obtenerMovimientoPorCuenta(String numeroCuenta) {

        if(this.cuentaRepository.existsById(numeroCuenta)){

            return this.cuentaRepository.findById(numeroCuenta).get();
        }
        
        return null;
    }
    
}
