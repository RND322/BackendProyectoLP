package hn.lenguajes1700.proyecto.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyecto.Entities.TarjetaComprador;

@Repository
public interface TarjetaCompradorRepository extends CrudRepository<TarjetaComprador, Integer> {

    List<TarjetaComprador> findByComprador_Idcomprador(int idcomprador);
}