package hn.lenguajes1700.proyectofinal.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Data
@Entity
@Table(name = "compradores")
public class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcomprador;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String telefono;

    @NotNull
    private String correoelectronico;

    @NotNull
    private String contrasena;

    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TarjetaComprador> tarjetasComprador;
}