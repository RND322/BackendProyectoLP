package hn.lenguajes1700.proyectofinal.Service;

import java.util.List;

import hn.lenguajes1700.proyectofinal.Entities.TarjetaComprador;

public interface TarjetaCompradorService {

    public TarjetaComprador agregarTarjeta(TarjetaComprador tarjetacomprador);
    public TarjetaComprador obtenerTarjetaPorId(int tarjetacomprador);
    public List<TarjetaComprador> obtenerTarjetasPorComprador(int idcomprador);
    public TarjetaComprador actualizarTarjetaComprador(int idtarjetacomprador, TarjetaComprador tarjetaCompradoractualizada);
}
