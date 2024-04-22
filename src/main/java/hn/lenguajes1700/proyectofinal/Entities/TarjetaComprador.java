package hn.lenguajes1700.proyectofinal.Entities;

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
import jakarta.validation.constraints.NotNull;


@Data
@Entity
@Table(name = "Tarjetas_Compradores")
public class TarjetaComprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtarjetacomprador;

    @NotNull
    private String numerotarjetacomprador;

    @NotNull
    private LocalDate fechavencimientocomprador;

    @NotNull
    private String codigoseguridadcomprador;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "idcomprador")
    private Comprador comprador;
}