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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import hn.lenguajes1700.proyectofinal.Entities.Vendedor;
import hn.lenguajes1700.proyectofinal.Service.Impl.VendedorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorController {

    @Autowired
    private VendedorServiceImpl vendedorServiceImpl;

    @PostMapping("/registro")
    @Operation(summary = "Registra a un vendedor.")
     @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Vendedor registrado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Vendedor.class)) }),
      @ApiResponse(responseCode = "400", description = "Vendedor no registrado", content = @Content)
    })
    public Vendedor registrarNuevoVendedor(@RequestBody Vendedor vendedor) {
        return vendedorServiceImpl.registrarNuevoVendedor(vendedor);
    }

    @PostMapping("/autenticacion")
    @Operation(summary = "Autentica a un vendedor.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Vendedor autenticado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Vendedor.class)) }),
      @ApiResponse(responseCode = "400", description = "Vendedor no autenticado", content = @Content)
    })
      public Vendedor autenticarVendedor(@RequestParam String correoelectronico, @RequestParam String contrasena) {
        return vendedorServiceImpl.autenticarVendedor(correoelectronico, contrasena);
    }

    @GetMapping("/obtener/{idvendedor}")
    @Operation(summary = "Obtiene a un vendedor mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Vendedor obtenido correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Vendedor.class)) }),
      @ApiResponse(responseCode = "400", description = "Vendedor no obtenido", content = @Content)
    })
    public Vendedor obtenerVendedorPorId(@PathVariable int idvendedor) {
        return vendedorServiceImpl.obtenerVendedorPorId(idvendedor);
    }

    @GetMapping("/todos")
    @Operation(summary = "Lista a todos los vendedores registrados.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Vendedores listados correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Vendedor.class)) }),
      @ApiResponse(responseCode = "400", description = "Vendedores no listados", content = @Content)
    })
    public List<Vendedor> obtenerTodosLosVendedores() {
        return vendedorServiceImpl.obtenerTodosLosVendedores();
    }

    @PutMapping("/actualizar/{idvendedor}")
    @Operation(summary = "Actualiza los datos a un vendedor mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Vendedor actualizado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Vendedor.class)) }),
      @ApiResponse(responseCode = "400", description = "Vendedor no actualizado", content = @Content)
    })
    public void actualizarVendedor(@PathVariable int idvendedor, @RequestBody Vendedor vendedor) {
        vendedorServiceImpl.actualizarVendedor(idvendedor, vendedor);
    }

    @DeleteMapping("/eliminar/{idvendedor}")
    @Operation(summary = "Elimina a un vendedor registrado.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Vendedor eliminado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Vendedor.class)) }),
      @ApiResponse(responseCode = "400", description = "Vendedor no eliminado", content = @Content)
    })
    public void eliminarVendedor(@PathVariable int idvendedor) {
        vendedorServiceImpl.eliminarVendedor(idvendedor);
    }
}
