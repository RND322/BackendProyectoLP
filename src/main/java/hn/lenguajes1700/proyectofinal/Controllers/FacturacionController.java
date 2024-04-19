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

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionServiceImpl facturacionServiceImpl;
    
        @GetMapping("/{idfactura}")
    public Facturacion obtenerFacturaPorId(@PathVariable int idfactura) {
        return facturacionServiceImpl.obtenerFacturaPorId(idfactura);
    }

    @GetMapping("/{idfactura}/detalles")
    public List<DetalleFactura> obtenerDetallesFactura(@PathVariable int idfactura) {
        return facturacionServiceImpl.obtenerDetallesFactura(idfactura);
    }
}
