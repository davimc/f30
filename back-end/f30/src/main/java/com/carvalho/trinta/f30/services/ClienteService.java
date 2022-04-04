package com.carvalho.trinta.f30.services;

import com.carvalho.trinta.f30.DTO.ClienteDTO;
import com.carvalho.trinta.f30.domains.Cliente;
import com.carvalho.trinta.f30.repositories.ClienteRepository;
import com.carvalho.trinta.f30.resources.ClienteResource;
import com.carvalho.trinta.f30.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Page<ClienteDTO> findAll() {
        int page= 0;
        int size = 5;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");

        return new PageImpl<ClienteDTO>(repository.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList()), pageRequest,size);
    }
    public ClienteDTO findById(Long id) {
        Optional<ClienteDTO> obj = repository.findById(id).map(ClienteDTO::new);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getSimpleName()));
    }
}
