package hn.lenguajes1700.proyecto.Entities;

import lombok.Data;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Data
@Entity
@Table(name = "Tarjetas_Vendedores")
public class TarjetaVendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtarjetavendedor;

    private String numerotarjeta;

    private LocalDate fechavencimiento;
    
    private String codigoseguridad;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "idvendedor")
    private Vendedor vendedor;
}