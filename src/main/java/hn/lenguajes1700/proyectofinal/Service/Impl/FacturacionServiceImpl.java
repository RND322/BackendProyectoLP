package hn.lenguajes1700.proyectofinal.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyectofinal.Entities.DetalleFactura;
import hn.lenguajes1700.proyectofinal.Entities.Facturacion;
import hn.lenguajes1700.proyectofinal.Repository.DetalleFacturaRepository;
import hn.lenguajes1700.proyectofinal.Repository.FacturacionRepository;
import hn.lenguajes1700.proyectofinal.Service.FacturacionService;

@Service
public class FacturacionServiceImpl implements FacturacionService{

    
    @Autowired
    private FacturacionRepository facturacionRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public Facturacion obtenerFacturaPorId(int idfactura) {
        // Obtener la factura por su ID
        return facturacionRepository.findById(idfactura).orElse(null);
    }

    @Override
    public List<DetalleFactura> obtenerDetallesFactura(int idfactura) {
        // Obtener los detalles de la factura por el ID de la factura
        return detalleFacturaRepository.findByFacturaIdfactura(idfactura);
    }
}
