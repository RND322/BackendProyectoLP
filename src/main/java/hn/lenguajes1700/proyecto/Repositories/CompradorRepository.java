package hn.lenguajes1700.proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyecto.Entities.Comprador;

@Repository
public interface CompradorRepository extends CrudRepository<Comprador, Integer> {

    Comprador findByCorreoelectronico(String correoelectronico);

    Comprador findByCorreoelectronicoAndContrasena(String correoelectronico, String contrasena);

}