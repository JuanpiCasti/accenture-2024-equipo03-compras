package ar.frba.utn.sharksales.accenture2024equipo03compras.dtos.output;

import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.ItemOrdenCompra;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.RegistroEstadoOrdenCompra;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrdenCompraOutputDTO {
    private Long id;
    private Long idProveedor;
    private LocalDateTime fechaGeneracion;
    private LocalDateTime fechaEntrega;
    private List<ItemOrdenCompra> detalles;
    private List<RegistroEstadoOrdenCompra> historialEstados;
    private String medioDePago;
    private String estadoOrdenCompra;
}
