package hn.lenguajes1700.proyecto.Service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyecto.Entities.Inventario;
import hn.lenguajes1700.proyecto.Entities.Producto;
import hn.lenguajes1700.proyecto.Entities.Vendedor;
import hn.lenguajes1700.proyecto.Repositories.InventarioRepository;
import hn.lenguajes1700.proyecto.Repositories.ProductoRepository;
import hn.lenguajes1700.proyecto.Repositories.VendedorRepository;
import hn.lenguajes1700.proyecto.Service.InventarioService;

@Service
public class InventarioServiceImpl implements InventarioService{

     @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private VendedorRepository vendedorRepository;
    /* 
    @Override
    public void agregarProductoInventario(int idvendedor, int idproducto, int cantidad) {
        Vendedor vendedor = vendedorRepository.findById(idvendedor)
                .orElseThrow(() -> new RuntimeException("No se encontró el vendedor con ID: " + idvendedor));
        
        Producto producto = productoRepository.findById(idproducto)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID: " + idproducto));

        Inventario inventario = new Inventario();
        inventario.setVendedor(vendedor);
        inventario.setProducto(producto);
        inventario.setCantidad(cantidad);

        inventarioRepository.save(inventario);
    }
    */

    @Override
    public void agregarProductoInventario(int idvendedor, int idproducto, int cantidad) {
    Vendedor vendedor = vendedorRepository.findById(idvendedor)
            .orElseThrow(() -> new RuntimeException("No se encontró el vendedor con ID: " + idvendedor));
    
    Producto producto = productoRepository.findById(idproducto)
            .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID: " + idproducto));

    Inventario inventario = new Inventario();
    inventario.setVendedor(vendedor);
    // Aquí agrega el producto al inventario
    inventario.getProducto().add(producto);
    inventario.setCantidad(cantidad);

    inventarioRepository.save(inventario);
}
    @Override
    public void actualizarCantidadProductoInventario(int idvendedor, int idproducto, int cantidad) {
        Vendedor vendedor = vendedorRepository.findById(idvendedor)
                .orElseThrow(() -> new RuntimeException("No se encontró el vendedor con ID: " + idvendedor));
        
        Producto producto = productoRepository.findById(idproducto)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID: " + idproducto));

        Optional<Inventario> inventarioOptional = inventarioRepository.findByVendedorAndProducto(vendedor, producto);
        if (inventarioOptional.isPresent()) {
            Inventario inventario = inventarioOptional.get();
            inventario.setCantidad(cantidad);
            inventarioRepository.save(inventario);
        } else {
            throw new RuntimeException("No se encontró el producto en el inventario del vendedor");
        }
    }

    @Override
    public void eliminarProductoInventario(int idvendedor, int idproducto) {
        Vendedor vendedor = vendedorRepository.findById(idvendedor)
                .orElseThrow(() -> new RuntimeException("No se encontró el vendedor con ID: " + idvendedor));
    
        Producto producto = productoRepository.findById(idproducto)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID: " + idproducto));
    
        inventarioRepository.deleteByVendedorAndProducto(vendedor, producto);
    }

    @Override
    public int obtenerCantidadProductoInventario(int idvendedor, int idproducto) {
        Vendedor vendedor = vendedorRepository.findById(idvendedor)
                .orElseThrow(() -> new RuntimeException("No se encontró el vendedor con ID: " + idvendedor));
        
        Producto producto = productoRepository.findById(idproducto)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID: " + idproducto));

        Optional<Inventario> inventarioOptional = inventarioRepository.findByVendedorAndProducto(vendedor, producto);
        if (inventarioOptional.isPresent()) {
            return inventarioOptional.get().getCantidad();
        } else {
            throw new RuntimeException("No se encontró el producto en el inventario del vendedor");
        }
    }

    @Override
    public List<Inventario> obtenerInventarioPorVendedor(int idvendedor) {
        Vendedor vendedor = vendedorRepository.findById(idvendedor)
                .orElseThrow(() -> new RuntimeException("No se encontró el vendedor con ID: " + idvendedor));
        
        return inventarioRepository.findByVendedor(vendedor);
    }
}
