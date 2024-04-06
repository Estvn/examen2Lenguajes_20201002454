package hn.unah.lenguajes1900.data.examen2lenguajes.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id
    private String dni;

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;

    @OneToOne(mappedBy = "cliente")
    private Direccion direccion;

}
