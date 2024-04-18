package hn.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyecto.Entities.DetalleFactura;
import hn.lenguajes1700.proyecto.Entities.Facturacion;
import hn.lenguajes1700.proyecto.Service.Implementation.FacturacionServiceImpl;

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionServiceImpl facturacionServiceImpl;

    @GetMapping("/buscar/{idfactura}")
    public Facturacion obtenerFacturaPorId(@PathVariable int idfactura) {
        return facturacionServiceImpl.obtenerFacturaPorId(idfactura);
    }

    @GetMapping("/detalles/{iddetallesfactura}")
    public List<DetalleFactura> obtenerDetallesFactura(@PathVariable int iddetallesfactura) {
        return facturacionServiceImpl.obtenerDetallesFactura(iddetallesfactura);
    }
}
