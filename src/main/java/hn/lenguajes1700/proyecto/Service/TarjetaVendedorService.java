package hn.lenguajes1700.proyecto.Service;

import java.util.List;

import hn.lenguajes1700.proyecto.Entities.TarjetaVendedor;

public interface TarjetaVendedorService {

    public TarjetaVendedor agregarTarjeta(TarjetaVendedor tarjetavendedor);
    public TarjetaVendedor obtenerTarjetaPorId(int idtarjetavendedor);
    public List<TarjetaVendedor> obtenerTarjetasPorVendedor(int idVendedor);
}
