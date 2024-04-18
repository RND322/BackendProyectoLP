package hn.lenguajes1700.proyecto.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyecto.Entities.DetalleFactura;
import hn.lenguajes1700.proyecto.Entities.Facturacion;

@Repository
public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, Integer> {

    List<DetalleFactura> findByFactura(Facturacion factura);
}
