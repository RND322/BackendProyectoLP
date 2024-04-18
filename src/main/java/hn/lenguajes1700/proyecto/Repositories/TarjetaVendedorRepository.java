package hn.lenguajes1700.proyecto.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyecto.Entities.TarjetaVendedor;

@Repository
public interface TarjetaVendedorRepository extends CrudRepository<TarjetaVendedor, Integer> {

    List<TarjetaVendedor> findByVendedor_Idvendedor(int idvendedor);
    
}
