package hn.lenguajes1700.proyectofinal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyectofinal.Entities.Vendedor;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

    Vendedor findByCorreoelectronico(String correoelectronico);

}