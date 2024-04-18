package hn.lenguajes1700.proyecto.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyecto.Entities.Comprador;
import hn.lenguajes1700.proyecto.Repositories.CompradorRepository;
import hn.lenguajes1700.proyecto.Service.CompradorService;

@Service
public class CompradorServiceImpl implements CompradorService {

      @Autowired
    private CompradorRepository compradorRepository;

    @Override
    public Comprador registrarNuevoComprador(Comprador comprador) {
        // Verifica si ya existe un comprador con el mismo correo electrónico
        Comprador compradorExistente = compradorRepository.findByCorreoelectronico(comprador.getCorreoelectronico());
        if (compradorExistente != null) {
            // Si ya existe un comprador con el mismo correo electrónico, lanza una excepción.
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }
        
        // Si el correo electrónico no está registrado, guardar el nuevo comprador
        return compradorRepository.save(comprador);
    }


    @Override
    public Comprador autenticarComprador(String correoelectronico, String contrasena) {
        return compradorRepository.findByCorreoelectronicoAndContrasena(correoelectronico, contrasena);
    }

    @Override
    public Comprador obtenerCompradorPorId(int idcomprador) {
        return compradorRepository.findById(idcomprador).orElse(null);
    }

    @Override
    public List<Comprador> obtenerTodosLosCompradores() {
        return (List<Comprador>) compradorRepository.findAll();
    }
}
