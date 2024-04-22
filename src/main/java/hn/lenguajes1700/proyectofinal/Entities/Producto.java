package hn.lenguajes1700.proyectofinal.Entities;

import lombok.Data;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;



@Data 
@Entity
@Table(name = "productos")
//@JsonIgnoreProperties({"vendedor"})
@JsonIgnoreProperties({"carritocompra"})
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproducto;

    @ManyToOne
    @JoinColumn(name = "idvendedor")
    private Vendedor vendedor;
    
    @JsonIgnoreProperties("productos")
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    @NotNull
    private String nombre;

    private String descripcion;

    @Column(precision = 10, scale = 2)
    @NotNull
    private BigDecimal precio;

    @NotNull
    private String imagen;

    @NotNull
    private Integer cantidadproducto;
    
    @JoinColumn(name = "idcarrito")
    @ManyToOne
    private CarritoCompra carritocompra;
}