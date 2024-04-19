package hn.lenguajes1700.proyectofinal.Service;

import java.util.List;

import hn.lenguajes1700.proyectofinal.Entities.Producto;

public interface ProductoService {

    public Producto guardarProducto(Producto producto);
    public Producto obtenerProductoPorId(int idproducto);
    public List<Producto> obtenerTodosProductos();
    public void eliminarProducto(int idproducto);
    public Producto actualizarProducto(int idproducto, Producto productoactualizado);
}
