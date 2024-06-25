package ar.frba.utn.sharksales.accenture2024equipo03compras.models.repositories;

import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {
}
