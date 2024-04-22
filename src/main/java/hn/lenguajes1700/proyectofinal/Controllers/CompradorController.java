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

import hn.lenguajes1700.proyectofinal.Entities.Comprador;
import hn.lenguajes1700.proyectofinal.Service.Impl.CompradorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/comprador")
public class CompradorController {

    @Autowired
    private CompradorServiceImpl compradorServiceImpl;

     @PostMapping("/registro")
     @Operation(summary = "Registra a un comprador.")
     @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Comprador registrado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Comprador.class)) }),
      @ApiResponse(responseCode = "400", description = "Comprador no registrado", content = @Content)
    })
    public Comprador registrarNuevoComprador(@RequestBody Comprador comprador) {
        return compradorServiceImpl.registrarNuevoComprador(comprador);
    }

    @PostMapping("/autenticar")
    @Operation(summary = "Autentica a un comprador.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Comprador autenticado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Comprador.class)) }),
      @ApiResponse(responseCode = "400", description = "Comprador no autenticado", content = @Content)
    })
    public Comprador autenticarComprador(@RequestParam String correo, @RequestParam String contrasena) {
        return compradorServiceImpl.autenticarComprador(correo, contrasena);
    }

    @GetMapping("obtener/{idcomprador}")
    @Operation(summary = "Obtiene a un comprador mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Comprador obtenido correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Comprador.class)) }),
      @ApiResponse(responseCode = "400", description = "Comprador no obtenido", content = @Content)
    })
    public Comprador obtenerCompradorPorId(@PathVariable int idcomprador) {
        return compradorServiceImpl.obtenerCompradorPorId(idcomprador);
    }

    @GetMapping("/todos")
    @Operation(summary = "Lista a todos los compradores registrados.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Compradores listados correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Comprador.class)) }),
      @ApiResponse(responseCode = "400", description = "Compradores no listados", content = @Content)
    })
    public List<Comprador> obtenerTodosLosCompradores() {
        return compradorServiceImpl.obtenerTodosLosCompradores();
    }

    @PutMapping("actualizar/{idcomprador}")
    @Operation(summary = "Actualiza los datos a un comprador mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Comprador actualizado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Comprador.class)) }),
      @ApiResponse(responseCode = "400", description = "Comprador no actualizado", content = @Content)
    })
    public void actualizarComprador(@PathVariable int idcomprador, @RequestBody Comprador comprador) {
        compradorServiceImpl.actualizarComprador(idcomprador, comprador);
    }

    @DeleteMapping("eliminar/{idcomprador}")
    @Operation(summary = "Elimina a un comprador registrado.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Comprador eliminado correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Comprador.class)) }),
      @ApiResponse(responseCode = "400", description = "Comprador no eliminado", content = @Content)
    })
    public void eliminarComprador(@PathVariable int idcomprador) {
        compradorServiceImpl.eliminarComprador(idcomprador);
    }
}
