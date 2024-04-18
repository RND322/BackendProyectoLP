package hn.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyecto.Entities.Inventario;
import hn.lenguajes1700.proyecto.Service.Implementation.InventarioServiceImpl;


@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    
    @Autowired
    private InventarioServiceImpl inventarioServiceImpl;

    @PostMapping("/agregar")
    public void agregarProductoInventario(@RequestParam int idvendedor, @RequestParam int idproducto, @RequestParam int cantidad) {
        inventarioServiceImpl.agregarProductoInventario(idvendedor, idproducto, cantidad);
    }

    @PutMapping("/actualizar")
    public void actualizarCantidadProductoInventario(@RequestParam int idvendedor, @RequestParam int idproducto, @RequestParam int cantidad) {
        inventarioServiceImpl.actualizarCantidadProductoInventario(idvendedor, idproducto, cantidad);
    }

    @DeleteMapping("/eliminar")
    public void eliminarProductoInventario(@RequestParam int idvendedor, @RequestParam int idproducto) {
        inventarioServiceImpl.eliminarProductoInventario(idvendedor, idproducto);
    }

    @GetMapping("/cantidad")
    public int obtenerCantidadProductoInventario(@RequestParam int idvendedor, @RequestParam int idproducto) {
        return inventarioServiceImpl.obtenerCantidadProductoInventario(idvendedor, idproducto);
    }

    @GetMapping("/vendedor/{idvendedor}")
    public List<Inventario> obtenerInventarioPorVendedor(@PathVariable int idvendedor) {
        return inventarioServiceImpl.obtenerInventarioPorVendedor(idvendedor);
    }
}
