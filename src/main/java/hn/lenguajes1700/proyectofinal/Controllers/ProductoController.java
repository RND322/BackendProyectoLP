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

import hn.lenguajes1700.proyectofinal.Entities.Categoria;
import hn.lenguajes1700.proyectofinal.Entities.Producto;
import hn.lenguajes1700.proyectofinal.Entities.Vendedor;
import hn.lenguajes1700.proyectofinal.Repository.CategoriaRepository;
import hn.lenguajes1700.proyectofinal.Repository.VendedorRepository;
import hn.lenguajes1700.proyectofinal.Service.Impl.ProductoServiceImpl;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoServiceImpl;

    @Autowired
    VendedorRepository vendedorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;
    
    @PostMapping("/guardar")
    public Producto guardarProducto(@RequestBody Producto producto) {
    // Obtener el vendedor por su ID
    Vendedor vendedor = vendedorRepository.findById(producto.getVendedor().getIdvendedor())
            .orElseThrow(() -> new RuntimeException("No se encontró el vendedor con ID: " + producto.getVendedor().getIdvendedor()));

    // Obtener la categoría por su ID
    Categoria categoria = categoriaRepository.findById(producto.getCategoria().getIdcategoria())
            .orElseThrow(() -> new RuntimeException("No se encontró la categoría con ID: " + producto.getCategoria().getIdcategoria()));

    // Asignar el vendedor y la categoría al producto
    producto.setVendedor(vendedor);
    producto.setCategoria(categoria);

    // Guardar el producto en la base de datos
    return productoServiceImpl.guardarProducto(producto);
    }
 
    @GetMapping("obtener/{idproducto}")
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
