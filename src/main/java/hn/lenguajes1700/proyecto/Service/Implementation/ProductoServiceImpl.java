package hn.lenguajes1700.proyecto.Service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyecto.Entities.Producto;
import hn.lenguajes1700.proyecto.Repositories.ProductoRepository;
import hn.lenguajes1700.proyecto.Service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

     @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(int idproducto) {
        productoRepository.deleteById(idproducto);
    }

    @Override
    public Producto obtenerProductoPorId(int idproducto) {
        Optional<Producto> productoOptional = productoRepository.findById(idproducto);
        if (productoOptional.isPresent()) {
            return productoOptional.get();
        } else {
            throw new RuntimeException("No se encontró el producto con ID: " + idproducto);
        }
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return (List<Producto>) productoRepository.findAll();
    }
}
