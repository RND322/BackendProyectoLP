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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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
    @Operation(summary = "Guarda un Producto.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Producto creado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Producto.class)) }),
      @ApiResponse(responseCode = "400", description = "Producto no creado", content = @Content)
    })
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
    @Operation(summary = "Obtiene un producto mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Producto obtenido correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Producto.class)) }),
      @ApiResponse(responseCode = "400", description = "Producto no obtenido", content = @Content)
    })
    public Producto obtenerProductoPorId(@PathVariable int idproducto) {
        return productoServiceImpl.obtenerProductoPorId(idproducto);
    }

    @GetMapping("/todos")
    @Operation(summary = "Obtiene todos los productos.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Productos obtenidos", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Producto.class)) }),
      @ApiResponse(responseCode = "400", description = "Productos no obtenidos", content = @Content)
    })
    public List<Producto> obtenerTodosProductos() {
        return productoServiceImpl.obtenerTodosProductos();
    }

    @PutMapping("/actualizar/{idproducto}")
    @Operation(summary = "Actualiza datos del producto mediante el ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Producto.class)) }),
      @ApiResponse(responseCode = "400", description = "Producto no actualizado", content = @Content)
    })
    public Producto actualizarProducto(@PathVariable int idproducto, @RequestBody Producto productoactualizado) {
    return productoServiceImpl.actualizarProducto(idproducto, productoactualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Elimina un producto mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Producto.class)) }),
      @ApiResponse(responseCode = "400", description = "Producto no eliminado", content = @Content)
    })
    public void eliminarProducto(@PathVariable int idproducto) {
        productoServiceImpl.eliminarProducto(idproducto);
    }
}
