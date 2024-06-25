package ar.frba.utn.sharksales.accenture2024equipo03compras.dtos.input;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrdenCompraInputDTO {
    private Long idProveedor;
    private String medioDePago;
    private List<ItemOrdenCompraInputDTO> detalles = new ArrayList<>();
}
