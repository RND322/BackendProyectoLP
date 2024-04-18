package hn.lenguajes1700.proyecto.Service;

import java.util.List;

import hn.lenguajes1700.proyecto.Entities.Categoria;

public interface CategoriaService {

    public Categoria agregarCategoria(Categoria categoria);
    public Categoria actualizarCategoria(Categoria categoria);
    public void eliminarCategoria(int idcategoria);
    public Categoria obtenerCategoriaPorId(int idcategoria);
    public List<Categoria> obtenerTodasLasCategorias();
}
