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

import hn.lenguajes1700.proyecto.Entities.Categoria;
import hn.lenguajes1700.proyecto.Service.Implementation.CategoriaServiceImpl;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaServiceImpl;

    @PostMapping("/agregar")
    public Categoria agregarCategoria(@RequestBody Categoria categoria) {
        return categoriaServiceImpl.agregarCategoria(categoria);
    }

    @PutMapping("/actualizar")
    public Categoria actualizarCategoria(@RequestBody Categoria categoria) {
        return categoriaServiceImpl.actualizarCategoria(categoria);
    }

    @DeleteMapping("/eliminar/{idcategoria}")
    public void eliminarCategoria(@PathVariable int idcategoria) {
        categoriaServiceImpl.eliminarCategoria(idcategoria);
    }

    @GetMapping("/buscar/{idcategoria}")
    public Categoria obtenerCategoriaPorId(@PathVariable int idcategoria) {
        return categoriaServiceImpl.obtenerCategoriaPorId(idcategoria);
    }

    @GetMapping("/todas")
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaServiceImpl.obtenerTodasLasCategorias();
    }
}
