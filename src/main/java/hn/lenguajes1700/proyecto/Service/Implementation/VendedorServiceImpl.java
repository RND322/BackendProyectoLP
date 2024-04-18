package hn.lenguajes1700.proyecto.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyecto.Entities.Vendedor;
import hn.lenguajes1700.proyecto.Repositories.VendedorRepository;
import hn.lenguajes1700.proyecto.Service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {

     @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public Vendedor registrarNuevoVendedor(Vendedor vendedor) {
         // Verifica si ya existe un comprador con el mismo correo electrónico.
        Vendedor vendedorExistente = vendedorRepository.findByCorreoelectronico(vendedor.getCorreoelectronico());
        if (vendedorExistente != null) {
            // Si ya existe un comprador con el mismo correo electrónico, lanza una excepción, envia un mensaje de error.
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }
        
        // Si el correo electrónico no está registrado, guardar el nuevo comprador.
        return vendedorRepository.save(vendedor);
    }

    @Override
    public Vendedor autenticarVendedor(String correoelectronico, String contrasena) {
        return vendedorRepository.findByCorreoelectronicoAndContrasena(correoelectronico, contrasena);
    }

    @Override
    public Vendedor obtenerVendedorPorId(int idvendedor) {
        return vendedorRepository.findById(idvendedor).orElse(null);
    }

    @Override
    public List<Vendedor> obtenerTodosLosVendedors() {
        return (List<Vendedor>) vendedorRepository.findAll();
    }
}
