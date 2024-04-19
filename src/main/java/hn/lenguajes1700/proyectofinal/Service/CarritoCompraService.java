package hn.lenguajes1700.proyectofinal.Service;

import java.util.List;

import hn.lenguajes1700.proyectofinal.Entities.CarritoCompra;

public interface CarritoCompraService {

        public void agregarProductoAlCarrito(int idcomprador, int idproducto, int cantidad);
        public void eliminarProductoDelCarrito(int idcomprador, int idproducto);
        public void realizarPedido(int idcomprador);
        public List<CarritoCompra> obtenerProductosEnCarrito(int idcomprador);
        public void vaciarCarrito(int idcomprador);
}
