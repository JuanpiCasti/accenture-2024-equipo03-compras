package ar.frba.utn.sharksales.accenture2024equipo03compras.models.repositories;

import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.ItemOrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrdenCompraRepository extends JpaRepository<ItemOrdenCompra, Long> {
}
