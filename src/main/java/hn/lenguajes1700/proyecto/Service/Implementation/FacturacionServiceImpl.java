package hn.lenguajes1700.proyecto.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyecto.Entities.DetalleFactura;
import hn.lenguajes1700.proyecto.Entities.Facturacion;
import hn.lenguajes1700.proyecto.Repositories.DetalleFacturaRepository;
import hn.lenguajes1700.proyecto.Repositories.FacturacionRepository;
import hn.lenguajes1700.proyecto.Service.FacturacionService;

@Service
public class FacturacionServiceImpl implements FacturacionService {

     @Autowired
    private FacturacionRepository facturacionRepository;

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public Facturacion obtenerFacturaPorId(int idfactura) {
        return facturacionRepository.findById(idfactura).orElse(null);
    }

    @Override
    public List<DetalleFactura> obtenerDetallesFactura(int idfactura) {
        Facturacion factura = facturacionRepository.findById(idfactura).orElse(null);
        if (factura != null) {
            return detalleFacturaRepository.findByFactura(factura);
        }
        return new ArrayList<>(); // Retorna una lista vacía si no se encuentra la factura
    }
}
