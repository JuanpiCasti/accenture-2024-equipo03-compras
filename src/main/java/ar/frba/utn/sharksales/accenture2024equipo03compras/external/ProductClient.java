package ar.frba.utn.sharksales.accenture2024equipo03compras.external;

import ar.frba.utn.sharksales.accenture2024equipo03compras.dtos.input.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sharksales-monolith")
public interface ProductClient {
    @GetMapping("/productos/{id}")
    ProductoDTO getProductById(@PathVariable("id") Long id);
}
