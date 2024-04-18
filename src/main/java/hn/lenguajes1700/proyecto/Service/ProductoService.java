package hn.lenguajes1700.proyecto.Service;

import java.util.List;

import hn.lenguajes1700.proyecto.Entities.Producto;
    
public interface ProductoService {

    public Producto agregarProducto(Producto producto);
    public Producto actualizarProducto(Producto producto);
    public void eliminarProducto(int idproducto);
    public Producto obtenerProductoPorId(int idproducto);
    public List<Producto> obtenerTodosLosProductos();
}
