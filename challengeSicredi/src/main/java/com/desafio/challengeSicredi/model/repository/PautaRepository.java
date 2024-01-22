package com.desafio.challengeSicredi.model.repository;

import com.desafio.challengeSicredi.model.entity.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer> {

}
