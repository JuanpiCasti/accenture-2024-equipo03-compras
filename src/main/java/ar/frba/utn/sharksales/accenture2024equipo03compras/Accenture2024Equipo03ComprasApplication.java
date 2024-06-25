package ar.frba.utn.sharksales.accenture2024equipo03compras;

import ar.frba.utn.sharksales.accenture2024equipo03compras.runners.RabbitAmqpRecepcionBajoStockRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Accenture2024Equipo03ComprasApplication {

    @Bean
    public CommandLineRunner recepcionBajoStock() {
        return new RabbitAmqpRecepcionBajoStockRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(Accenture2024Equipo03ComprasApplication.class, args);
    }
}
