package ar.frba.utn.sharksales.accenture2024equipo03compras.receivers;

import com.rabbitmq.client.Delivery;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.UnsupportedEncodingException;

@RabbitListener(queues = "bajo_stock")
public class ReceptorBajoStock {

    @RabbitHandler
    public void receive(byte[] in) {
        System.out.println(" [x] Received '" + in + "'");
    }

}
