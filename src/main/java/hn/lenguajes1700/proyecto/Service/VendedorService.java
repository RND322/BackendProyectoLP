package hn.lenguajes1700.proyecto.Service;

import java.util.List;

import hn.lenguajes1700.proyecto.Entities.Vendedor;

public interface VendedorService {

    public Vendedor registrarNuevoVendedor(Vendedor vendedor);
    public Vendedor autenticarVendedor(String correoelectronico, String contrasena);
    public Vendedor obtenerVendedorPorId(int idvendedor);
    public List<Vendedor> obtenerTodosLosVendedors();
   
}