package ar.frba.utn.sharksales.accenture2024equipo03compras.receivers;

import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.ItemOrdenCompra;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.MedioDePago;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.OrdenCompra;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.repositories.OrdenCompraRepository;
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

    @RabbitHandler
    public void receive(byte[] in) {
        String s = new String(in);
        List<String> argList = List.of(s.split(","));

        Long idProducto = Long.parseLong(argList.get(0));
        Integer cantidad = Integer.parseInt(argList.get(1));

        // TODO: Ir a buscar id del proveedor de ese producto (Feign) -- Por estas cosas vendria bien graphql
        Long idProveedor = 1L;
        // TODO: Ir a buscar precio del producto (Feign)
        BigDecimal precio = BigDecimal.valueOf(1000.0);

        // Crear orden de compra con ese proveedor
        // Agregar item a la orden de compra
        // Guardar orden de compra

        OrdenCompra ordenCompra = new OrdenCompra(idProveedor, MedioDePago.CUENTA_CORRIENTE);
        ItemOrdenCompra itemOrdenCompra = new ItemOrdenCompra(cantidad, idProducto, precio);
        ordenCompra.agregarItem(itemOrdenCompra);

        ordenCompraRepository.save(ordenCompra);

    }

}
