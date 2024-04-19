package hn.lenguajes1700.proyectofinal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyectofinal.Entities.Comprador;

@Repository
public interface CompradorRepository extends CrudRepository<Comprador, Integer> {

    Comprador findByCorreoelectronico(String correoElectronico);


}