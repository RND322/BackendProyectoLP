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

import hn.lenguajes1700.proyectofinal.Entities.DireccionComprador;
import hn.lenguajes1700.proyectofinal.Service.Impl.DireccionCompradorServiceImpl;

@RestController
@RequestMapping("/api/direccion")
public class DireccionCompradorController {

    @Autowired
    private DireccionCompradorServiceImpl direccionCompradorServiceImpl;

    
    @PostMapping("/agregar")
    public DireccionComprador agregarDireccion(@RequestBody DireccionComprador direccion) {
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
