package hn.lenguajes1700.proyecto.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyecto.Entities.TarjetaVendedor;
import hn.lenguajes1700.proyecto.Repositories.TarjetaVendedorRepository;
import hn.lenguajes1700.proyecto.Service.TarjetaVendedorService;

@Service
public class TarjetaVendedorServiceImpl implements TarjetaVendedorService {

    @Autowired
    private TarjetaVendedorRepository tarjetavendedorRepository;

    @Override
    public TarjetaVendedor agregarTarjeta(TarjetaVendedor tarjetavendedor) {
        return tarjetavendedorRepository.save(tarjetavendedor);
    }

    @Override
    public TarjetaVendedor obtenerTarjetaPorId(int idtarjetavendedor) {
        return tarjetavendedorRepository.findById(idtarjetavendedor).orElse(null);
    }

    @Override
    public List<TarjetaVendedor> obtenerTarjetasPorVendedor(int idvendedor) {
        return tarjetavendedorRepository.findByVendedor_Idvendedor(idvendedor);
    }

}
