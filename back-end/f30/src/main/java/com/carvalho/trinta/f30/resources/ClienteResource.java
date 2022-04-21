package com.carvalho.trinta.f30.resources;

import com.carvalho.trinta.f30.DTO.ClienteDTO;
import com.carvalho.trinta.f30.DTO.ClienteNewDTO;
import com.carvalho.trinta.f30.domains.Cliente;
import com.carvalho.trinta.f30.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping
    public Page<ClienteDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findByIdDTO(id));
    }


    // TODO criar post (clienteNewDTO)
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid ClienteNewDTO objDTO) {
        Cliente obj = service.insert(objDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ClienteDTO objDTO) {
        return ResponseEntity.ok().body(service.update(id, objDTO));
    }
}
