package hn.lenguajes1700.proyectofinal.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyectofinal.Entities.Producto;
import hn.lenguajes1700.proyectofinal.Service.Impl.ProductoServiceImpl;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoServiceImpl;

    
    @PostMapping("/guardar")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoServiceImpl.guardarProducto(producto);
    }

    @GetMapping("/{idproducto}")
    public Producto obtenerProductoPorId(@PathVariable int idproducto) {
        return productoServiceImpl.obtenerProductoPorId(idproducto);
    }

    @GetMapping("/todos")
    public List<Producto> obtenerTodosProductos() {
        return productoServiceImpl.obtenerTodosProductos();
    }

    @PutMapping("/actualizar/{idproducto}")
    public Producto actualizarProducto(@PathVariable int idproducto, @RequestBody Producto productoactualizado) {
    return productoServiceImpl.actualizarProducto(idproducto, productoactualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable int idproducto) {
        productoServiceImpl.eliminarProducto(idproducto);
    }
}
