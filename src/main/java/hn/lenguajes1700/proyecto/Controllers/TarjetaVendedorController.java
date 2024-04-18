package hn.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyecto.Entities.TarjetaVendedor;
import hn.lenguajes1700.proyecto.Service.Implementation.TarjetaVendedorServiceImpl;

@RestController
@RequestMapping("/api/tvendedor")
public class TarjetaVendedorController {

    @Autowired
    private TarjetaVendedorServiceImpl tarjetaVendedorServiceImpl;

    @PostMapping("/agregar")
    public TarjetaVendedor agregarTarjeta(@RequestBody TarjetaVendedor tarjetavendedor) {
        return tarjetaVendedorServiceImpl.agregarTarjeta(tarjetavendedor);
    }

    @GetMapping("/buscar/{idtarjetavendedor}")
    public TarjetaVendedor obtenerTarjetaPorId(@PathVariable int idtarjetavendedor) {
        return tarjetaVendedorServiceImpl.obtenerTarjetaPorId(idtarjetavendedor);
    }

    @GetMapping("/buscarPorVendedor/{idvendedor}")
    public List<TarjetaVendedor> obtenerTarjetasPorVendedor(@PathVariable int idvendedor) {
        return tarjetaVendedorServiceImpl.obtenerTarjetasPorVendedor(idvendedor);
    }
}
