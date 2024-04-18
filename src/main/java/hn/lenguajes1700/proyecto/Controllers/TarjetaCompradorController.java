package hn.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyecto.Entities.TarjetaComprador;
import hn.lenguajes1700.proyecto.Service.Implementation.TarjetaCompradorServiceImpl;

@RestController
@RequestMapping("/api/tcomprador")
public class TarjetaCompradorController {

    @Autowired
    private TarjetaCompradorServiceImpl tarjetaCompradorServiceImpl;

    @PostMapping("/agregar")
    public TarjetaComprador agregarTarjeta(@RequestBody TarjetaComprador tarjetaComprador) {
        return tarjetaCompradorServiceImpl.agregarTarjeta(tarjetaComprador);
    }

    @GetMapping("/buscar/{idtarjetacomprador}")
    public TarjetaComprador obtenerTarjetaPorId(@PathVariable int idtarjetacomprador) {
        return tarjetaCompradorServiceImpl.obtenerTarjetaPorId(idtarjetacomprador);
    }

    @GetMapping("/buscarporcomprador/{idcomprador}")
    public List<TarjetaComprador> obtenerTarjetasPorComprador(@PathVariable int idcomprador) {
        return tarjetaCompradorServiceImpl.obtenerTarjetasPorComprador(idcomprador);
    }
}
