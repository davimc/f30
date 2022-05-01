package com.carvalho.trinta.f30.services;

import com.carvalho.trinta.f30.DTO.cliente.ClienteDTO;
import com.carvalho.trinta.f30.DTO.cliente.ClienteNewDTO;
import com.carvalho.trinta.f30.DTO.cliente.ClienteUpdateDTO;
import com.carvalho.trinta.f30.domains.Cliente;
import com.carvalho.trinta.f30.repositories.ClienteRepository;
import com.carvalho.trinta.f30.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    private Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getSimpleName()));
    }
    public ClienteDTO findByIdDTO(Long id) {
        return new ClienteDTO(
                findById(id)
        );

    }
   @Transactional
    public Cliente insert(ClienteNewDTO obj) {
        Cliente newObj = fromDTO(obj);
        return repository.save(newObj);
    }


    public ClienteDTO update(Long id, ClienteUpdateDTO objDTO) {
        Cliente obj = findById(id);

        obj = ClienteUpdateDTO.update(obj, objDTO);
        return new ClienteDTO(repository.save(obj));
    }


   /* private Cliente fromDTO(ClienteDTO obj) {
        Cliente newObj = new Cliente(obj.getNome(),obj.getCpf(),obj.getEmail(), ,obj.getDataNascimento());
        newObj.getTelefone().addAll(obj.getTelefone());
        return newObj;
    }*/
    private Cliente fromDTO (ClienteNewDTO objDTO) {
        Cliente obj = new Cliente(objDTO.getNome(),objDTO.getCpf(),objDTO.getEmail(),LocalDate.now(), objDTO.getDataNascimento());
        obj.getTelefone().add(objDTO.getTelefone1());
        if(objDTO.getTelefone2()==null)
        obj.getTelefone().add(objDTO.getTelefone2());
        if(objDTO.getTelefone3()==null)
        obj.getTelefone().add(objDTO.getTelefone3());

        return obj;
    }
}
