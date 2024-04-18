package hn.lenguajes1700.proyecto.Service;

import java.util.List;

import hn.lenguajes1700.proyecto.Entities.TarjetaComprador;

public interface TarjetaCompradorService {

    public TarjetaComprador agregarTarjeta(TarjetaComprador tarjetacomprador);
    public TarjetaComprador obtenerTarjetaPorId(int idtarjetacomprador);
    public List<TarjetaComprador> obtenerTarjetasPorComprador(int idcomprador);
}
