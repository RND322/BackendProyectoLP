package hn.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import hn.lenguajes1700.proyecto.Entities.Comprador;
import hn.lenguajes1700.proyecto.Service.Implementation.CompradorServiceImpl;

@RestController
@RequestMapping("/api/comprador")
public class CompradorController {

    @Autowired
    private CompradorServiceImpl compradorServiceImpl;

    @PostMapping("/registrar")
    public Comprador registrarComprador(@RequestBody Comprador comprador) {
        return compradorServiceImpl.registrarNuevoComprador(comprador);
    }

    @GetMapping("buscar/{idcomprador}")
    public Comprador obtenerCompradorPorId(@PathVariable int idcomprador) {
        return compradorServiceImpl.obtenerCompradorPorId(idcomprador);
    }

    @GetMapping("/todos")
    public List<Comprador> obtenerTodosLosCompradores() {
        return compradorServiceImpl.obtenerTodosLosCompradores();
    }

    @PostMapping("/autenticar")
    public Comprador autenticarComprador(@RequestParam String correo, @RequestParam String contrasena) {
        return compradorServiceImpl.autenticarComprador(correo, contrasena);
    }

    @DeleteMapping("/eliminar/{idcliente}")
    public void eliminarComprador(@PathVariable int idcomprador) {
        compradorServiceImpl.eliminarComprador(idcomprador);
    }
     
}
