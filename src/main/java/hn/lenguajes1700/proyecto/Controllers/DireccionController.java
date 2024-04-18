package hn.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyecto.Entities.DireccionComprador;
import hn.lenguajes1700.proyecto.Service.Implementation.DireccionServiceImpl;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {

     @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/agregar")
    public DireccionComprador agregarDireccion(@RequestBody DireccionComprador direccion) {
        return direccionServiceImpl.agregarDireccion(direccion);
    }

    @PutMapping("/actualizar")
    public DireccionComprador actualizarDireccion(@RequestBody DireccionComprador direccion) {
        return direccionServiceImpl.actualizarDireccion(direccion);
    }

    @DeleteMapping("/eliminar/{iddireccion}")
    public void eliminarDireccion(@PathVariable int iddireccion) {
        direccionServiceImpl.eliminarDireccion(iddireccion);
    }

    @GetMapping("/buscar/{iddireccion}")
    public DireccionComprador obtenerDireccionPorId(@PathVariable int iddireccion) {
        return direccionServiceImpl.obtenerDireccionPorId(iddireccion);
    }

    @GetMapping("/comprador/{idcomprador}")
    public List<DireccionComprador> obtenerDireccionesPorComprador(@PathVariable int idcomprador) {
        return direccionServiceImpl.obtenerDireccionesPorComprador(idcomprador);
    }
}
