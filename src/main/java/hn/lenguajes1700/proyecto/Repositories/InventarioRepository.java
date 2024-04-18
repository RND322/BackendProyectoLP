package hn.lenguajes1700.proyecto.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyecto.Entities.Inventario;
import hn.lenguajes1700.proyecto.Entities.Producto;
import hn.lenguajes1700.proyecto.Entities.Vendedor;

@Repository
public interface InventarioRepository  extends CrudRepository<Inventario, Integer> {

    Optional<Inventario> findByVendedorAndProducto(Vendedor vendedor, Producto producto);

    void deleteByVendedorAndProducto(Vendedor vendedor, Producto producto);

    List<Inventario> findByVendedor(Vendedor vendedor); 

}

