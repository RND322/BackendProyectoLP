package hn.lenguajes1700.proyecto.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyecto.Entities.TarjetaComprador;
import hn.lenguajes1700.proyecto.Repositories.TarjetaCompradorRepository;
import hn.lenguajes1700.proyecto.Service.TarjetaCompradorService;

@Service
public class TarjetaCompradorServiceImpl implements TarjetaCompradorService{

    @Autowired
    private TarjetaCompradorRepository tarjetaRepository;

    @Override
    public TarjetaComprador agregarTarjeta(TarjetaComprador tarjetacomprador) {
        return tarjetaRepository.save(tarjetacomprador);
    }

    @Override
    public TarjetaComprador obtenerTarjetaPorId(int idtarjetacomprador) {
        return tarjetaRepository.findById(idtarjetacomprador).orElse(null);
    }

    @Override
    public List<TarjetaComprador> obtenerTarjetasPorComprador(int idcomprador) {
        return tarjetaRepository.findByComprador_Idcomprador(idcomprador);
    }
}
