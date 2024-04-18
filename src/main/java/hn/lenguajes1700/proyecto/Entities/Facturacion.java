package hn.lenguajes1700.proyecto.Entities;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "idcomprador")
    private Comprador comprador;

    @OneToOne
    @JoinColumn(name = "idcarrito")
    private CarritoCompra carrito;

    private LocalDate fechafacturacion;

    @Column(precision = 10, scale = 2)
    private BigDecimal total;
}
