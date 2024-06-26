package ar.frba.utn.sharksales.accenture2024equipo03compras.dtos.input;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoDTO {
    private Long id;
    private ProveedorDTO proveedor;
    private BigDecimal precioCompra;
}
