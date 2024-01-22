package com.desafio.challengeSicredi.model.service;

import com.desafio.challengeSicredi.infra.exceptions.NotFoundException;
import com.desafio.challengeSicredi.model.dto.PautaDtoIn;
import com.desafio.challengeSicredi.model.dto.PautaDtoOut;
import com.desafio.challengeSicredi.model.entity.Pauta;
import com.desafio.challengeSicredi.model.repository.PautaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PautaService {
    private final PautaRepository pautaRepository;
    private final ObjectMapper objectMapper;

    public List<Pauta> findAll(){
        return this.pautaRepository.findAll();
    }
    public PautaDtoOut savePauta(PautaDtoIn pautaDtoIn){
        Pauta pautaToSave = objectMapper.convertValue(pautaDtoIn,Pauta.class);
        PautaDtoOut pautaDtoOut = this.objectMapper.convertValue(
                this.pautaRepository.save(pautaToSave),PautaDtoOut.class
        );
        return pautaDtoOut;
    }

    public Pauta findByid(Integer idPauta) throws NotFoundException{
        return this.pautaRepository.findById(idPauta).orElseThrow(()-> new NotFoundException("Pauta nao localizada"));
    }

}
