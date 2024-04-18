package hn.lenguajes1700.proyecto.Controllers;

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

import hn.lenguajes1700.proyecto.Entities.Producto;

import hn.lenguajes1700.proyecto.Service.Implementation.ProductoServiceImpl;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    
    @Autowired
    private ProductoServiceImpl productoServiceImpl;

    @PostMapping("/agregar")
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoServiceImpl.agregarProducto(producto);
    }

    @PutMapping("/actualizar")
    public Producto actualizarProducto(@RequestBody Producto producto) {
        return productoServiceImpl.actualizarProducto(producto);
    }

    @DeleteMapping("/eliminar/{idproducto}")
    public void eliminarProducto(@PathVariable int idproducto) {
        productoServiceImpl.eliminarProducto(idproducto);
    }

    @GetMapping("/buscar/{idproducto}")
    public Producto obtenerProductoPorId(@PathVariable int idproducto) {
        return productoServiceImpl.obtenerProductoPorId(idproducto);
    }

    @GetMapping("/listar")
    public List<Producto> obtenerTodosLosProductos() {
        return productoServiceImpl.obtenerTodosLosProductos();
    }
}
