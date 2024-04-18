package hn.lenguajes1700.proyecto.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyecto.Entities.Categoria;
import hn.lenguajes1700.proyecto.Repositories.CategoriaRepository;
import hn.lenguajes1700.proyecto.Service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        if (categoriaRepository.existsById(categoria.getIdcategoria())) {
            return categoriaRepository.save(categoria);
        } else {
            throw new RuntimeException("La categoría no existe.");
        }
    }

    @Override
    public void eliminarCategoria(int idcategoria) {
        if (categoriaRepository.existsById(idcategoria)) {
            categoriaRepository.deleteById(idcategoria);
        } else {
            throw new RuntimeException("La categoría no existe.");
        }
    }

    @Override
    public Categoria obtenerCategoriaPorId(int idcategoria) {
        return categoriaRepository.findById(idcategoria).orElse(null);
    }

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return (List<Categoria>) categoriaRepository.findAll();
    }
}
