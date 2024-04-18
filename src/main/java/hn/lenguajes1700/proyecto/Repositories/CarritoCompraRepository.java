package hn.lenguajes1700.proyecto.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyecto.Entities.CarritoCompra;
import hn.lenguajes1700.proyecto.Entities.Comprador;
import hn.lenguajes1700.proyecto.Entities.Producto;

@Repository
public interface CarritoCompraRepository extends CrudRepository<CarritoCompra, Integer> {

    CarritoCompra findByCompradorAndProducto(Comprador comprador, Producto producto);

    List<CarritoCompra> findByComprador_Idcomprador(Comprador comprador);

}
