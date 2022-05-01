package com.carvalho.trinta.f30.repositories;

import com.carvalho.trinta.f30.domains.Cliente;
import com.carvalho.trinta.f30.domains.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Transactional(readOnly = true)
    Optional<Endereco> findById(Long id);
    @Transactional(readOnly = true)
    List<Endereco> findByNome(String nome);
    List<Endereco> findByCliente(Cliente cliente);
}
