package ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "item_orden_compra")
@NoArgsConstructor
public class ItemOrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer cantidad;

    @Column(name = "id_producto")
    private Long idProducto;

    @Column
    private BigDecimal precio;

    public ItemOrdenCompra(Integer cantidad, Long idProducto, BigDecimal precio ) {
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.precio = precio;
    }

}
