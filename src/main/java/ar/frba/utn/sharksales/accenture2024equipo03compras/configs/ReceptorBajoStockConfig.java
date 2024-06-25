package ar.frba.utn.sharksales.accenture2024equipo03compras.configs;

import ar.frba.utn.sharksales.accenture2024equipo03compras.receivers.ReceptorBajoStock;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceptorBajoStockConfig {

    @Bean
    public Queue bajo_stock() {

        return new Queue("bajo_stock");
    }

    @Bean
    public ReceptorBajoStock receiver() {
        return new ReceptorBajoStock();
    }
}
