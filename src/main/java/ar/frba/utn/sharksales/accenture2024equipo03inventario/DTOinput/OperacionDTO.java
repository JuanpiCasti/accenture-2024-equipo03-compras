package ar.frba.utn.sharksales.accenture2024equipo03inventario.DTOinput;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperacionDTO {
    private LocalDateTime fecha;
    private Long productoid;
    private int cantidad;
}
