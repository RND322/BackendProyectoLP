package hn.lenguajes1700.proyectofinal.Service;

import java.util.List;

import hn.lenguajes1700.proyectofinal.Entities.Comprador;

public interface CompradorService {

    public Comprador registrarNuevoComprador(Comprador comprador);
    public Comprador autenticarComprador(String correoelectronico, String contrasena);
    public Comprador obtenerCompradorPorId(int idcomprador);
    public List<Comprador> obtenerTodosLosCompradores();
    public void eliminarComprador(int idcomprador);
    public void actualizarComprador(int idcomprador, Comprador compradoractualizado);
}
