package ar.frba.utn.sharksales.accenture2024equipo03compras.dtos.input;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class OperacionDTO {
    private LocalDateTime fecha;
    private Long productoid;
    private int cantidad;
}
