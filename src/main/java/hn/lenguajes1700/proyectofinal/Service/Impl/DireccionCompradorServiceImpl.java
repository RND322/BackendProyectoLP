package hn.lenguajes1700.proyectofinal.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyectofinal.Entities.DireccionComprador;
import hn.lenguajes1700.proyectofinal.Repository.DireccionCompradorRepository;
import hn.lenguajes1700.proyectofinal.Service.DireccionCompradorService;

@Service
public class DireccionCompradorServiceImpl implements DireccionCompradorService {

    @Autowired
    private DireccionCompradorRepository direccionCompradorRepository;

    @Override
    public DireccionComprador agregarDireccion(DireccionComprador direccion) {
        // Asociar la dirección con un comprador y guardarla en la base de datos
        return direccionCompradorRepository.save(direccion);
    }

    @Override
    public DireccionComprador actualizarDireccion(int iddireccion, DireccionComprador direccionactualizada) {
    DireccionComprador direccionExistente = direccionCompradorRepository.findById(iddireccion)
            .orElseThrow(() -> new RuntimeException("No se encontró la dirección con ID: " + iddireccion));

    // Actualizar los campos opcionales solo si se proporcionan en direccionactualizada
    if (direccionactualizada.getCalle() != null) {
        direccionExistente.setCalle(direccionactualizada.getCalle());
    }
    if (direccionactualizada.getCiudad() != null) {
        direccionExistente.setCiudad(direccionactualizada.getCiudad());
    }
    if (direccionactualizada.getPais() != null) {
        direccionExistente.setPais(direccionactualizada.getPais());
    }
   
    // Guardar y devolver la dirección actualizada en la base de datos
    return direccionCompradorRepository.save(direccionExistente);
    }

    @Override
    public void eliminarDireccion(int idDireccion) {
        // Eliminar la dirección por su ID
        direccionCompradorRepository.deleteById(idDireccion);
    }

    @Override
    public DireccionComprador obtenerDireccionPorId(int iddireccion) {
        // Obtener la dirección por su ID
        Optional<DireccionComprador> direccionOptional = direccionCompradorRepository.findById(iddireccion);
        return direccionOptional.orElse(null);
    }
}
