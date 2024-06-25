package ar.frba.utn.sharksales.accenture2024equipo03compras.dtos.input;

import lombok.Data;

import java.util.List;

@Data
public class ItemOrdenCompraInputDTO {
    private Long idProducto;
    private Integer cantidad;
    private List<ItemOrdenCompraInputDTO> detalles;
}
