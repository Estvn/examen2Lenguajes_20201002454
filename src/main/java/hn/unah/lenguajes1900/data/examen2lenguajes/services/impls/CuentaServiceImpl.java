package hn.unah.lenguajes1900.data.examen2lenguajes.services.impls;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cliente;
import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Cuenta;
import hn.unah.lenguajes1900.data.examen2lenguajes.entities.Movimiento;
import hn.unah.lenguajes1900.data.examen2lenguajes.repositories.ClienteRepository;
import hn.unah.lenguajes1900.data.examen2lenguajes.repositories.CuentaRepository;
import hn.unah.lenguajes1900.data.examen2lenguajes.repositories.MovimientoRepository;
import hn.unah.lenguajes1900.data.examen2lenguajes.services.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    MovimientoRepository movimientoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {
        
        cuenta.setFechaApertura(LocalDate.now());
        cuenta.setEstado(true);

        if((cuenta.getSaldo() > 500) && (!this.cuentaRepository.existsById(cuenta.getNumeroCuenta()))){

            if(cuenta.getMovimientos() != null){
                
                List<Movimiento> movimientos = cuenta.getMovimientos();

                for (Movimiento movimiento : movimientos) {

                    movimiento.setCuenta(cuenta);
                    this.movimientoRepository.save(movimiento);
                    
                }
            }
            return this.cuentaRepository.save(cuenta);
        }
        return null;
    }

    @Override
    public Cliente asociarCuentaCliente(String dni, String numeroCuenta) {
        
        if(this.clienteRepository.existsById(dni) && this.cuentaRepository.existsById(numeroCuenta)){

            this.clienteRepository.findById(dni).get().getCuentas().add(this.cuentaRepository.findById(numeroCuenta).get());
            return this.clienteRepository.findById(dni).get();
        }
        return null;
    }
    
}
