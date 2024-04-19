package hn.lenguajes1700.proyectofinal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyectofinal.Entities.DireccionComprador;

@Repository
public interface DireccionCompradorRepository extends CrudRepository<DireccionComprador, Integer> {

}
