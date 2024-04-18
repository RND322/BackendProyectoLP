package hn.lenguajes1700.proyecto.Service;

import java.util.List;

import hn.lenguajes1700.proyecto.Entities.DireccionComprador;

public interface DireccionService {

    public DireccionComprador agregarDireccion(DireccionComprador direccion);
    public DireccionComprador actualizarDireccion(DireccionComprador direccion);
    public void eliminarDireccion(int iddireccion);
    public DireccionComprador obtenerDireccionPorId(int iddireccion);
    public List<DireccionComprador> obtenerDireccionesPorComprador(int idcomprador);
}
