package hn.lenguajes1700.proyectofinal.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name = "vendedores")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvendedor;

    @NotNull
    private String nombrevendedor;

    @NotNull
    private String descripcion;

    @NotNull
    private String correoelectronico;

    @NotNull
    private String contrasena;

    @NotNull
    private Integer cuentavendedor;
}