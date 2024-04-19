package hn.lenguajes1700.proyectofinal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyectofinal.Entities.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

}
