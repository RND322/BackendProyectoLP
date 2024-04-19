package hn.lenguajes1700.proyectofinal.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyectofinal.Entities.DetalleFactura;


@Repository
public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, Integer> {

    List<DetalleFactura> findByFacturaIdfactura(int idfactura);

}
