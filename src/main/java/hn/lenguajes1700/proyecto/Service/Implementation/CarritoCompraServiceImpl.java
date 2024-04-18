package hn.lenguajes1700.proyecto.Service.Implementation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes1700.proyecto.Entities.CarritoCompra;
import hn.lenguajes1700.proyecto.Entities.Comprador;
import hn.lenguajes1700.proyecto.Entities.DetalleFactura;
import hn.lenguajes1700.proyecto.Entities.Facturacion;
import hn.lenguajes1700.proyecto.Entities.Inventario;
import hn.lenguajes1700.proyecto.Entities.Producto;
import hn.lenguajes1700.proyecto.Repositories.CarritoCompraRepository;
import hn.lenguajes1700.proyecto.Repositories.CompradorRepository;
import hn.lenguajes1700.proyecto.Repositories.DetalleFacturaRepository;
import hn.lenguajes1700.proyecto.Repositories.FacturacionRepository;
import hn.lenguajes1700.proyecto.Repositories.ProductoRepository;
import hn.lenguajes1700.proyecto.Service.CarritoCompraService;

@Service
public class CarritoCompraServiceImpl implements CarritoCompraService {

     @Autowired
    private CarritoCompraRepository carritoCompraRepository;

    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private FacturacionRepository facturacionRepository;

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public void agregarProductoAlCarrito(int idcomprador, int idproducto, int cantidad) {
        Comprador comprador = compradorRepository.findById(idcomprador).orElse(null);
        Producto producto = productoRepository.findById(idproducto).orElse(null);

        if (comprador != null && producto != null) {
            CarritoCompra carritoCompra = carritoCompraRepository.findByCompradorAndProducto(comprador, producto);
            if (carritoCompra == null) {
                carritoCompra = new CarritoCompra();
                carritoCompra.setComprador(comprador);
                carritoCompra.setProducto(producto);
                carritoCompra.setCantidad(cantidad);
            } else {
                carritoCompra.setCantidad(carritoCompra.getCantidad() + cantidad);
            }
            carritoCompraRepository.save(carritoCompra);
        }
    }

    @Override
    public void eliminarProductoDelCarrito(int idcomprador, int idproducto) {
        Comprador comprador = compradorRepository.findById(idcomprador).orElse(null);
        Producto producto = productoRepository.findById(idproducto).orElse(null);

        if (comprador != null && producto != null) {
            CarritoCompra carritoCompra = carritoCompraRepository.findByCompradorAndProducto(comprador, producto);
            if (carritoCompra != null) {
                carritoCompraRepository.delete(carritoCompra);
            }
        }
    }

    @Override
    public List<CarritoCompra> obtenerProductosEnCarrito(int idcomprador) {
        Comprador comprador = compradorRepository.findById(idcomprador).orElse(null);
        if (comprador != null) {
            return carritoCompraRepository.findByComprador_Idcomprador(comprador);
        }
        return null;
    }

    @Override
    public void vaciarCarrito(int idcomprador) {
        Comprador comprador = compradorRepository.findById(idcomprador).orElse(null);
        if (comprador != null) {
            List<CarritoCompra> carritoCompras = carritoCompraRepository.findByComprador_Idcomprador(comprador);
            carritoCompraRepository.deleteAll(carritoCompras);
        }
    }

    @Override
    public void realizarPedido(int idcomprador) {
    // Obtener el carrito de compras del comprador
    Comprador comprador = compradorRepository.findById(idcomprador).orElse(null);
    if (comprador == null) {
        throw new RuntimeException("No se encontró el comprador con ID: " + idcomprador);
    }

    List<CarritoCompra> carritoCompras = carritoCompraRepository.findByComprador_Idcomprador(comprador);
    if (carritoCompras.isEmpty()) {
        throw new RuntimeException("El carrito de compras está vacío para el comprador con ID: " + idcomprador);
    }

    // Crear una nueva instancia de Facturacion para representar la factura del pedido
    Facturacion factura = new Facturacion();
    factura.setComprador(comprador);
    factura.setFechafacturacion(LocalDate.now());

    // Calcular el total de la factura y otros detalles relevantes
    BigDecimal totalFactura = BigDecimal.ZERO;
    List<DetalleFactura> detallesFactura = new ArrayList<>();
    for (CarritoCompra carritoCompra : carritoCompras) {
        Producto producto = carritoCompra.getProducto();
        int cantidadComprada = carritoCompra.getCantidad();
        Inventario inventario = producto.getInventario();

        // Verificar si hay suficiente inventario
        if (inventario.getCantidad() < cantidadComprada) {
            throw new RuntimeException("No hay suficiente inventario para el producto: " + producto.getNombre());
        }

        // Crear un nuevo detalle de factura
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setFactura(factura);
        detalleFactura.setProducto(producto);
        detalleFactura.setCantidad(cantidadComprada);
        detalleFactura.setSubtotal(producto.getPrecio().multiply(BigDecimal.valueOf(cantidadComprada)));

        // Actualizar la cantidad disponible en el inventario
        inventario.setCantidad(inventario.getCantidad() - cantidadComprada);

        // Agregar el detalle de factura a la lista
        detallesFactura.add(detalleFactura);

        // Calcular el total de la factura
        totalFactura = totalFactura.add(detalleFactura.getSubtotal());
    }

    // Establecer el total de la factura y guardar la factura en la base de datos
    factura.setTotal(totalFactura);
    facturacionRepository.save(factura);

    // Guardar los detalles de la factura en la base de datos
    detalleFacturaRepository.saveAll(detallesFactura);

    // Actualizar el estado de pago del carrito de compras a "pagado"
    for (CarritoCompra carritoCompra : carritoCompras) {
        carritoCompra.setEstado("pagado");
    }
    carritoCompraRepository.saveAll(carritoCompras);
}
    
}
