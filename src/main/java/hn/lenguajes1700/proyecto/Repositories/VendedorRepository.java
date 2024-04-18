package hn.lenguajes1700.proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyecto.Entities.Vendedor;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

    Vendedor findByCorreoelectronicoAndContrasena(String correoelectronico, String contrasena);

    Vendedor findByCorreoelectronico(String correoelectronico);
}