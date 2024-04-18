package hn.lenguajes1700.proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyecto.Entities.Facturacion;

@Repository
public interface FacturacionRepository extends CrudRepository<Facturacion, Integer> {

}
