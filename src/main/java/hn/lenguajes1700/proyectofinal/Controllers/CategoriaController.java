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
import hn.lenguajes1700.proyectofinal.Service.Impl.CategoriaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaServiceImpl;

    
    @PostMapping("/agregar")
    @Operation(summary = "Agrega una nueva categoria.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Categoria agragada correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Categoria.class)) }),
      @ApiResponse(responseCode = "400", description = "Categoria no agregada", content = @Content)
    })
    public Categoria agregarCategoria(@RequestBody Categoria categoria) {
        return categoriaServiceImpl.agregarCategoria(categoria);
    }

    @PutMapping("/actualizar/{idcategoria}")
    @Operation(summary = "Actualiza el nombre de la categoria y su descripcion mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Categoria actualizado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Categoria.class)) }),
      @ApiResponse(responseCode = "400", description = "Categoria no actualizado", content = @Content)
    })
    public Categoria actualizarCategoria(@PathVariable int idcategoria, @RequestBody Categoria categoriaactualizada) {
    return categoriaServiceImpl.actualizarCategoria(idcategoria, categoriaactualizada);
    }

    @DeleteMapping("/eliminar/{idcategoria}")
    @Operation(summary = "Elimina una categoria mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Categoria eliminado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Categoria.class)) }),
      @ApiResponse(responseCode = "400", description = "Categoria no eliminado", content = @Content)
    })
    public void eliminarCategoria(@PathVariable int idcategoria) {
        categoriaServiceImpl.eliminarCategoria(idcategoria);
    }

    @GetMapping("obtener/{idcategoria}")
    @Operation(summary = "Obtiene una categoria mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Categoria obtenida correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Categoria.class)) }),
      @ApiResponse(responseCode = "400", description = "Categoria no obtenido", content = @Content)
    })
    public Categoria obtenerCategoriaPorId(@PathVariable int idcategoria) {
        return categoriaServiceImpl.obtenerCategoriaPorId(idcategoria);
    }

    @GetMapping("/todas")
    @Operation(summary = "Obtiene todas las categorias.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Categorias Obtenidas correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Categoria.class)) }),
      @ApiResponse(responseCode = "400", description = "Categorias no obtenidas", content = @Content)
    })
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaServiceImpl.obtenerTodasLasCategorias();
    }
}
