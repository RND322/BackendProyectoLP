package hn.lenguajes1700.proyectofinal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyectofinal.Entities.Comprador;
import hn.lenguajes1700.proyectofinal.Entities.DireccionComprador;
import hn.lenguajes1700.proyectofinal.Repository.CompradorRepository;
import hn.lenguajes1700.proyectofinal.Service.Impl.DireccionCompradorServiceImpl;

@RestController
@RequestMapping("/api/direccion")
public class DireccionCompradorController {

    @Autowired
    private DireccionCompradorServiceImpl direccionCompradorServiceImpl;

    @Autowired
    private CompradorRepository compradorRepository;

    /* 
    @PostMapping("/agregar")
    public DireccionComprador agregarDireccion(@RequestBody DireccionComprador direccion) {
        return direccionCompradorServiceImpl.agregarDireccion(direccion);
    }
*/
    @PostMapping("/agregar")
    public DireccionComprador agregarDireccion(@RequestBody DireccionComprador direccion) {
    // Obtener el ID del comprador desde el objeto de dirección
    int idComprador = direccion.getComprador().getIdcomprador();

    // Buscar el comprador por su ID
    Comprador comprador = compradorRepository.findById(idComprador)
        .orElseThrow(() -> new RuntimeException("No se encontró el comprador con ID: " + idComprador));

    // Asignar el comprador al objeto DireccionComprador
    direccion.setComprador(comprador);

    // Guardar la dirección en la base de datos
    return direccionCompradorServiceImpl.agregarDireccion(direccion);
}

    

    @PutMapping("/actualizar/{iddireccion}")
    public DireccionComprador actualizarDireccion(@PathVariable int iddireccion, @RequestBody DireccionComprador direccionactualizada) {
    return direccionCompradorServiceImpl.actualizarDireccion(iddireccion, direccionactualizada);
    }

    @DeleteMapping("/eliminar/{iddireccion}")
    public void eliminarDireccion(@PathVariable int iddireccion) {
        direccionCompradorServiceImpl.eliminarDireccion(iddireccion);
    }

    @GetMapping("obtener/{iddireccion}")
    public DireccionComprador obtenerDireccionPorId(@PathVariable int iddireccion) {
        return direccionCompradorServiceImpl.obtenerDireccionPorId(iddireccion);
    }
}
