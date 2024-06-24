package ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "registro_estado_orden_compra")
@NoArgsConstructor
public class RegistroEstadoOrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime fechaCambio;

    @Column(name = "estado_orden_compra")
    @Enumerated(EnumType.STRING)
    private EstadoOrdenCompra estadoOrdenCompra;

    public RegistroEstadoOrdenCompra( LocalDateTime fechaCambio, EstadoOrdenCompra estadoOrdenCompra ) {
        this.fechaCambio = fechaCambio;
        this.estadoOrdenCompra = estadoOrdenCompra;
    }
}
