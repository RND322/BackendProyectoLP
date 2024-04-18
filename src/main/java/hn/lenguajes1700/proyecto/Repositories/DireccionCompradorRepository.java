package hn.lenguajes1700.proyecto.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyecto.Entities.DireccionComprador;

@Repository
public interface DireccionCompradorRepository extends CrudRepository<DireccionComprador, Integer> {

   List<DireccionComprador> findByComprador_Idcomprador(int idComprador);
}
