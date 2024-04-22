package hn.lenguajes1700.proyectofinal.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyectofinal.Entities.TarjetaComprador;
import hn.lenguajes1700.proyectofinal.Service.Impl.TarjetaCompradorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/tarjeta")
public class TarjetaCompradorController {

    @Autowired
    private TarjetaCompradorServiceImpl tarjetaCompradorServiceImpl;

     @PostMapping("/agregar")
     @Operation(summary = "Asocia una tarjeta a un comprador.")
     @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Tarjeta registrada correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = TarjetaComprador.class)) }),
      @ApiResponse(responseCode = "400", description = "Tarjeta no registrado", content = @Content)
    })
    public TarjetaComprador agregarTarjetaComprador(@RequestBody TarjetaComprador tarjetacomprador) {
        return tarjetaCompradorServiceImpl.agregarTarjeta(tarjetacomprador);
    }

    @GetMapping("obtener/{idtarjetacomprador}")
    @Operation(summary = "Obtiene una tarjeta mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Tarjeta obtenida correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = TarjetaComprador.class)) }),
      @ApiResponse(responseCode = "400", description = "Tarjeta no obtenida", content = @Content)
    })
    public TarjetaComprador obtenerTarjetaCompradorPorId(@PathVariable int idtarjetacomprador) {
        return tarjetaCompradorServiceImpl.obtenerTarjetaPorId(idtarjetacomprador);
    }

    @GetMapping("/comprador/{idcomprador}")
    @Operation(summary = "Obtiene las tarjetas asociadas a un comprador mediante el ID del comprador.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Tarjetas obtenidas correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = TarjetaComprador.class)) }),
      @ApiResponse(responseCode = "400", description = "Tarjetas no obtenidas", content = @Content)
    })
    public List<TarjetaComprador> obtenerTarjetasPorComprador(@PathVariable int idcomprador) {
        return tarjetaCompradorServiceImpl.obtenerTarjetasPorComprador(idcomprador);
    }

    @PutMapping("/actualizar/{idtarjetacomprador}")
    @Operation(summary = "Actualiza los datos de una tarjeta mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Tarjeta actualizada correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = TarjetaComprador.class)) }),
      @ApiResponse(responseCode = "400", description = "Tarjeta no actualizado", content = @Content)
    })
    public TarjetaComprador actualizarTarjetaComprador(@PathVariable int idtarjetacomprador, @RequestBody TarjetaComprador tarjetacompradoractualizada) {
        return tarjetaCompradorServiceImpl.actualizarTarjetaComprador(idtarjetacomprador, tarjetacompradoractualizada);
    }
}
