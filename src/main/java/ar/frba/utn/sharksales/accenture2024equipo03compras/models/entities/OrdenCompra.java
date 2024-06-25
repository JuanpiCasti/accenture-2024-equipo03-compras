package ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orden_compra")
@NoArgsConstructor
public class OrdenCompra  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "proveedor_id")
    private Long idProveedor;

    @Column
    private LocalDateTime fechaGeneracion;

    @Column
    private LocalDateTime fechaEntrega = null;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_compra_id", referencedColumnName = "id")
    private List<ItemOrdenCompra> detalles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RegistroEstadoOrdenCompra> historialEstados = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    @Column(name = "medio_de_pago")
    private MedioDePago medioDePago;

    @Column
    @Enumerated(EnumType.STRING)
    private EstadoOrdenCompra estadoOrdenCompra;

    public OrdenCompra(Long idProveedor, MedioDePago medioDePago) {
        this.fechaGeneracion = LocalDateTime.now();
        this.idProveedor = idProveedor;
        this.medioDePago = medioDePago;
        this.setEstadoOrdenCompra(EstadoOrdenCompra.PENDIENTE);
    }

    public void agregarItem(ItemOrdenCompra item) {
        this.detalles.add(item);
    }

    public void setEstadoOrdenCompra(EstadoOrdenCompra estadoOrdenCompra) {
        RegistroEstadoOrdenCompra registroEstadoOrdenCompra = new RegistroEstadoOrdenCompra(LocalDateTime.now(), this.estadoOrdenCompra);
        this.historialEstados.add(registroEstadoOrdenCompra);
        this.estadoOrdenCompra = estadoOrdenCompra;
    }
}
