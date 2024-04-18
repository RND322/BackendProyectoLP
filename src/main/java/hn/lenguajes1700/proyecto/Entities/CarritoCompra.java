package hn.lenguajes1700.proyecto.Entities;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "Carrito_Compras")
public class CarritoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcarrito;

    @ManyToOne
    @JoinColumn(name = "idcomprador")
    private Comprador comprador;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;

    private Integer cantidad;

    private String estado;

    private LocalDate fechacreacion;

    
}
