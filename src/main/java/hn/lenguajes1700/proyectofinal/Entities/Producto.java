package hn.lenguajes1700.proyectofinal.Entities;

import lombok.Data;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data 
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproducto;

    @ManyToOne
    @JoinColumn(name = "idvendedor")
    private Vendedor vendedor;

    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    private String nombre;

    private String descripcion;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;

    private String imagen;

    private Integer cantidadproducto;

    @ManyToOne
    @JoinColumn(name = "idcarrito")
    private CarritoCompra carritocompra;
}