package hn.lenguajes1700.proyectofinal.Service;

import hn.lenguajes1700.proyectofinal.Entities.DireccionComprador;

public interface DireccionCompradorService {

    public DireccionComprador agregarDireccion(DireccionComprador direccion);
    public DireccionComprador actualizarDireccion(int iddireccion, DireccionComprador direccionactualizada);
    public void eliminarDireccion(int iddireccion);
    public DireccionComprador obtenerDireccionPorId(int iddireccion);
}
 