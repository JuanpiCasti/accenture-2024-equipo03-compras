package ar.frba.utn.sharksales.accenture2024equipo03compras.controllers;

import ar.frba.utn.sharksales.accenture2024equipo03compras.dtos.input.ItemOrdenCompraInputDTO;
import ar.frba.utn.sharksales.accenture2024equipo03compras.dtos.input.OrdenCompraInputDTO;
import ar.frba.utn.sharksales.accenture2024equipo03compras.dtos.output.OrdenCompraOutputDTO;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.ItemOrdenCompra;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.MedioDePago;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.entities.OrdenCompra;
import ar.frba.utn.sharksales.accenture2024equipo03compras.models.repositories.OrdenCompraRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orden-compra")
public class OrdenCompraController {
    @Autowired
    OrdenCompraRepository ordenCompraRepository;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<OrdenCompraOutputDTO>> listar() {
        List<OrdenCompra> lista = ordenCompraRepository.findAll();
        List<OrdenCompraOutputDTO> listaOutput = lista.stream().map(
                ordenCompra -> modelMapper.map(ordenCompra, OrdenCompraOutputDTO.class)
        ).toList();
        return ResponseEntity.ok(listaOutput);
    }

    @PostMapping
    public ResponseEntity<OrdenCompraOutputDTO> crear(@RequestBody OrdenCompraInputDTO input) {

        System.out.println(input.getMedioDePago());

        OrdenCompra ordenCompra = new OrdenCompra(input.getIdProveedor(), MedioDePago.valueOf(input.getMedioDePago()));
        for (ItemOrdenCompraInputDTO itemInput : input.getDetalles()) {
            ItemOrdenCompra item = modelMapper.map(itemInput, ItemOrdenCompra.class);
            ordenCompra.agregarItem(item);
        }

        ordenCompraRepository.save(ordenCompra);

        OrdenCompraOutputDTO ordenCompraOutputDTO = modelMapper.map(ordenCompra, OrdenCompraOutputDTO.class);
        return ResponseEntity.ok(ordenCompraOutputDTO);
    }
}
