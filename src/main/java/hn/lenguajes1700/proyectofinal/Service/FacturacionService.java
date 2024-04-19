package hn.lenguajes1700.proyectofinal.Service;

import java.util.List;

import hn.lenguajes1700.proyectofinal.Entities.DetalleFactura;
import hn.lenguajes1700.proyectofinal.Entities.Facturacion;

public interface FacturacionService {
    
    public Facturacion obtenerFacturaPorId(int idfactura);
    public List<DetalleFactura> obtenerDetallesFactura(int idfactura);
}
