package com.desafio.challengeSicredi.model.repository;

import com.desafio.challengeSicredi.model.entity.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Integer> {

    Optional<Associado> findByCpf(String cpf);
}
