package hn.lenguajes1700.proyectofinal.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyectofinal.Entities.DetalleFactura;
import hn.lenguajes1700.proyectofinal.Entities.Facturacion;
import hn.lenguajes1700.proyectofinal.Service.Impl.FacturacionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionServiceImpl facturacionServiceImpl;
    
    @GetMapping("obtener/{idfactura}")
    @Operation(summary = "Obtiene una factura mediante su ID.")
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Factura obtenida correctamente", content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Facturacion.class)) }),
      @ApiResponse(responseCode = "400", description = "Factura no obtenida", content = @Content)
    })
    public Facturacion obtenerFacturaPorId(@PathVariable int idfactura) {
        return facturacionServiceImpl.obtenerFacturaPorId(idfactura);
    }

    @GetMapping("obtenerdetalles/{idfactura}/detalles")
    @Operation(summary = "Obtiene los detalles de una factura mediante su ID.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Detalles de factura obtenida correctamente", content = { @Content(mediaType = "application/json", 
        schema = @Schema(implementation = DetalleFactura.class)) }),
        @ApiResponse(responseCode = "400", description = "Detalles de factura no obtenida", content = @Content)
      })
    public List<DetalleFactura> obtenerDetallesFactura(@PathVariable int idfactura) {
        return facturacionServiceImpl.obtenerDetallesFactura(idfactura);
    }
}
