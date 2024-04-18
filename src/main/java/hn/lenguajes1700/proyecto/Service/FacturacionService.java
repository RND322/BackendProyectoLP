package hn.lenguajes1700.proyecto.Service;

import java.util.List;

import hn.lenguajes1700.proyecto.Entities.DetalleFactura;
import hn.lenguajes1700.proyecto.Entities.Facturacion;

public interface FacturacionService {

    //public Facturacion generarFactura(int idcomprador, int idcarrito);
    public Facturacion obtenerFacturaPorId(int idfactura);
    public List<DetalleFactura> obtenerDetallesFactura(int idfactura);
    //public void procesarPago(int idfactura);
}
