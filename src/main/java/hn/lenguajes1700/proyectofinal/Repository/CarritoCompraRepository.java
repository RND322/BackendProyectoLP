package hn.lenguajes1700.proyectofinal.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyectofinal.Entities.CarritoCompra;

@Repository
public interface CarritoCompraRepository extends CrudRepository<CarritoCompra, Integer> {

    List<CarritoCompra> findByCompradorIdcomprador(int idComprador);

}
