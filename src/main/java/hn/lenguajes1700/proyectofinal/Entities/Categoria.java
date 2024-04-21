package hn.lenguajes1700.proyectofinal.Entities;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcategoria;

    private String nombrecategoria;

    @JsonIgnoreProperties("categoria")
    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
    private List<Producto> productos;
}