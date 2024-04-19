package hn.lenguajes1700.proyectofinal.Service;

import java.util.List;

import hn.lenguajes1700.proyectofinal.Entities.Vendedor;

public interface VendedorService {

    public Vendedor registrarNuevoVendedor(Vendedor vendedor);
    public Vendedor autenticarVendedor(String correoelectronico, String contrasena);
    public Vendedor obtenerVendedorPorId(int idvendedor);
    public List<Vendedor> obtenerTodosLosVendedores();
    public void eliminarVendedor(int idvendedor);
    public void actualizarVendedor(int idvendedor, Vendedor vendedoractualizado);
}
