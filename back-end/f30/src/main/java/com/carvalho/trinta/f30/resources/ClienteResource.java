package com.carvalho.trinta.f30.resources;

import com.carvalho.trinta.f30.DTO.ClienteDTO;
import com.carvalho.trinta.f30.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Object obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
