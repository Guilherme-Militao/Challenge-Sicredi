package com.desafio.challengeSicredi.model.repository;

import com.desafio.challengeSicredi.model.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
}
