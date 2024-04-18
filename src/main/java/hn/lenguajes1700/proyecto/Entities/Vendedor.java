package hn.lenguajes1700.proyecto.Entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "vendedores")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvendedor;

    private String nombrevendedor;

    private String descripcion;

    private String correoelectronico;

    private String contrasena;

    @JsonManagedReference
    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    private List<TarjetaVendedor> tarjetasVendedor;
}