package hn.lenguajes1700.proyectofinal.Service;

import java.util.List;

import hn.lenguajes1700.proyectofinal.Entities.Categoria;


public interface CategoriaService {

    public Categoria agregarCategoria(Categoria categoria);
    public Categoria actualizarCategoria(int idcategoria, Categoria categoriaactualizada);
    public void eliminarCategoria(int idcategoria);
    public Categoria obtenerCategoriaPorId(int idcategoria);
    public List<Categoria> obtenerTodasLasCategorias();
}
