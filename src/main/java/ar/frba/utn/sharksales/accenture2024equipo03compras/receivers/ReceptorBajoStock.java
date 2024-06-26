package ar.frba.utn.sharksales.accenture2024equipo03compras.receivers;

import ar.frba.utn.sharksales.accenture2024equipo03compras.dtos.input.ProductoDTO;
import ar.frba.utn.sharksales.accenture2024equipo03compras.external.ProductClient;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.ItemOrdenCompra;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.MedioDePago;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.OrdenCompra;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.repositories.OrdenCompraRepository;
import ar.frba.utn.sharksales.accenture2024equipo03inventario.DTOinput.OperacionDTO;
import com.rabbitmq.client.Delivery;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

@RabbitListener(queues = "bajo_stock")
public class ReceptorBajoStock {

    @Autowired
    OrdenCompraRepository ordenCompraRepository;

    @Autowired
    ProductClient productClient;

    @RabbitHandler
    public void receive(OperacionDTO in) {

        // Print received values
        System.out.println("Received: " + in.getFecha().toString());
        System.out.println("Received: " + in.getProductoid());
        System.out.println("Received: " + in.getCantidad());


        Long idProducto = in.getProductoid();
        Integer cantidad = in.getCantidad();

        try {
            ProductoDTO productoDTO = productClient.getProductById(idProducto);
            Long idProveedor = productoDTO.getProveedor().getId();
            System.out.println("EL ID DEL PROVEEDOR ES: " + idProveedor);

            BigDecimal precio = productoDTO.getPrecioCompra();
            System.out.println("EL PRECIO DEL PRODUCTO ES: " + precio);

            // Crear orden de compra con ese proveedor
            // Agregar item a la orden de compra
            // Guardar orden de compra
            // Notificar al proveedor

            OrdenCompra ordenCompra = new OrdenCompra(idProveedor, MedioDePago.CUENTA_CORRIENTE);
            ItemOrdenCompra itemOrdenCompra = new ItemOrdenCompra(cantidad, idProducto, precio);
            ordenCompra.agregarItem(itemOrdenCompra);

            ordenCompraRepository.save(ordenCompra);
        } catch (Exception e) {
            System.out.println("Error al obtener el producto " + e.getMessage());
            throw new RuntimeException("Error al obtener el producto " + e.getMessage());
        }


    }

}
