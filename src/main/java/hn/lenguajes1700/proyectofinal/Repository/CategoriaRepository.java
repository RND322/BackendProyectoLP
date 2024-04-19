package hn.lenguajes1700.proyectofinal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes1700.proyectofinal.Entities.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

}
