package com.carvalho.trinta.f30.repositories;

import com.carvalho.trinta.f30.domains.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Transactional(readOnly = true)
    Optional<Cliente> findById(Long id);

}
