package com.desafio.challengeSicredi.model.repository;

import com.desafio.challengeSicredi.model.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {

    Optional<Sessao> findById(Integer id);
}
