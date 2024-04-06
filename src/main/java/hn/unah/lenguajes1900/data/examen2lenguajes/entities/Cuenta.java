package hn.unah.lenguajes1900.data.examen2lenguajes.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cuentas")
@Data
public class Cuenta {

    @Id
    @Column(name = "numerocuenta")
    private String numeroCuenta;

    private double saldo;

    @Column(name = "fechaapertura")
    private LocalDate fechaApertura;

    private boolean estado;

    private boolean sobregiro;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Cliente cliente;

    @OneToMany(mappedBy = "cuenta")
    private List<Movimiento> movimientos;

}
