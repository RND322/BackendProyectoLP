package hn.lenguajes1700.proyecto.Service;

import java.util.List;

import hn.lenguajes1700.proyecto.Entities.Inventario;

public interface InventarioService {

    public void agregarProductoInventario(int idvendedor, int idproducto, int cantidad);
    public void actualizarCantidadProductoInventario(int idvendedor, int idproducto, int cantidad);
    public void eliminarProductoInventario(int idvendedor, int idproducto);
    public int obtenerCantidadProductoInventario(int idvendedor, int idproducto);
    List<Inventario> obtenerInventarioPorVendedor(int idvendedor);
}
