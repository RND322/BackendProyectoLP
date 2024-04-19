package hn.lenguajes1700.proyectofinal.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyectofinal.Entities.Comprador;
import hn.lenguajes1700.proyectofinal.Service.Impl.CompradorServiceImpl;


@RestController
@RequestMapping("/api/comprador")
public class CompradorController {

    @Autowired
    private CompradorServiceImpl compradorServiceImpl;

     @PostMapping("/registro")
    public Comprador registrarNuevoComprador(@RequestBody Comprador comprador) {
        return compradorServiceImpl.registrarNuevoComprador(comprador);
    }

    @PostMapping("/autenticar")
    public Comprador autenticarComprador(@RequestParam String correo, @RequestParam String contrasena) {
        return compradorServiceImpl.autenticarComprador(correo, contrasena);
    }

    @GetMapping("obtener/{idcomprador}")
    public Comprador obtenerCompradorPorId(@PathVariable int idcomprador) {
        return compradorServiceImpl.obtenerCompradorPorId(idcomprador);
    }

    @GetMapping("/todos")
    public List<Comprador> obtenerTodosLosCompradores() {
        return compradorServiceImpl.obtenerTodosLosCompradores();
    }

    @PutMapping("actualizar/{idcomprador}")
    public void actualizarComprador(@PathVariable int idcomprador, @RequestBody Comprador comprador) {
        compradorServiceImpl.actualizarComprador(idcomprador, comprador);
    }

    @DeleteMapping("eliminar/{idcomprador}")
    public void eliminarComprador(@PathVariable int idcomprador) {
        compradorServiceImpl.eliminarComprador(idcomprador);
    }
}
