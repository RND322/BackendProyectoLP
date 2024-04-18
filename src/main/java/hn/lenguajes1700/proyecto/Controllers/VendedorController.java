package hn.lenguajes1700.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes1700.proyecto.Entities.Vendedor;

import hn.lenguajes1700.proyecto.Service.Implementation.VendedorServiceImpl;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorController {

    @Autowired
    private VendedorServiceImpl vendedorServiceImpl;

    @PostMapping("/registrar")
    public Vendedor registrarNuevoVendedor(@RequestBody Vendedor vendedor) {
        return vendedorServiceImpl.registrarNuevoVendedor(vendedor);
    }

    @PostMapping("/autenticar")
    public Vendedor autenticarVendedor(@RequestParam String correoelectronico, @RequestParam String contrasena) {
        return vendedorServiceImpl.autenticarVendedor(correoelectronico, contrasena);
    }

    @GetMapping("/buscar/{idvendedor}")
    public Vendedor obtenerVendedorPorId(@PathVariable int idvendedor) {
        return vendedorServiceImpl.obtenerVendedorPorId(idvendedor);
    }

    @GetMapping("/listar")
    public List<Vendedor> obtenerTodosLosVendedores() {
        return vendedorServiceImpl.obtenerTodosLosVendedors();
    }
}
