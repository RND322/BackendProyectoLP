package hn.lenguajes1700.proyecto.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyecto.Entities.DireccionComprador;
import hn.lenguajes1700.proyecto.Repositories.DireccionCompradorRepository;
import hn.lenguajes1700.proyecto.Service.DireccionService;

@Service
public class DireccionServiceImpl  implements DireccionService{

    
    @Autowired
    private DireccionCompradorRepository direccionRepository;

    @Override
    public DireccionComprador agregarDireccion(DireccionComprador direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public DireccionComprador actualizarDireccion(DireccionComprador direccion) {
        if (direccionRepository.existsById(direccion.getIddireccion())) {
            return direccionRepository.save(direccion);
        } else {
            throw new RuntimeException("La dirección no existe.");
        }
    }

    @Override
    public void eliminarDireccion(int iddireccion) {
        if (direccionRepository.existsById(iddireccion)) {
            direccionRepository.deleteById(iddireccion);
        } else {
            throw new RuntimeException("La dirección no existe.");
        }
    }

    @Override
    public DireccionComprador obtenerDireccionPorId(int iddireccion) {
        return direccionRepository.findById(iddireccion).orElse(null);
    }

    @Override
    public List<DireccionComprador> obtenerDireccionesPorComprador(int idcomprador) {
        return direccionRepository.findByComprador_Idcomprador(idcomprador);
    }
}

