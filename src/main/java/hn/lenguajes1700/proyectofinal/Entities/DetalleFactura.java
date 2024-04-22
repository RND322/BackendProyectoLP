package hn.lenguajes1700.proyectofinal.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "Detalle_Factura")
public class DetalleFactura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numerofactura;

    @ManyToOne
    @JoinColumn(name = "idfactura")
    private Facturacion factura;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;

    @NotNull
    private Integer cantidad;

    private Integer descuento;

    @Column(precision = 10, scale = 2)
    @NotNull
    private BigDecimal subtotal;

    @NotNull
    private String estadopago;

    private LocalDate fechaentrega;
}
