package hn.lenguajes1700.proyectofinal.Entities;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;

@Data
@Entity
@Table(name = "Direcciones_Compradores")
public class DireccionComprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddireccion;

    @OneToOne
    @JoinColumn(name = "idcomprador")
    private Comprador comprador;

    private String calle;

    private String ciudad;

    private String pais;
}