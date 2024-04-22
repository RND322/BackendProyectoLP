package hn.lenguajes1700.proyectofinal.Entities;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "facturacion")
public class Facturacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfactura;

    @OneToOne
    @JoinColumn(name = "idcarrito")
    private CarritoCompra carritocompra;

    @NotNull
    private LocalDate fechafacturacion;

    @Column(precision = 10, scale = 2)
    @NotNull
    private BigDecimal total;
}
