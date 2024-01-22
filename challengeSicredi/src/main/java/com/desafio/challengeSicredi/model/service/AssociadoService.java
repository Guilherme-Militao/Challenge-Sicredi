package com.desafio.challengeSicredi.model.service;

import com.desafio.challengeSicredi.infra.exceptions.NotFoundException;
import com.desafio.challengeSicredi.model.dto.AssociadoDtoIn;
import com.desafio.challengeSicredi.model.dto.AssociadoDtoOut;
import com.desafio.challengeSicredi.model.entity.Associado;
import com.desafio.challengeSicredi.model.repository.AssociadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssociadoService {

    private final AssociadoRepository associadoRepository;
    private final ObjectMapper objectMapper;


    public List<Associado> getAllAssociados(){
        return this.associadoRepository.findAll();
    }
    public AssociadoDtoOut saveAssociado(AssociadoDtoIn associadoDtoIn){
        Associado associadoToSave = this.objectMapper.convertValue(associadoDtoIn, Associado.class);
        return this.objectMapper.convertValue(
                this.associadoRepository.save(associadoToSave),
                    AssociadoDtoOut.class
        );
    }
    public AssociadoDtoOut updateAssociadoById(AssociadoDtoIn associadoDtoIn,Integer id) throws NotFoundException{
        Associado associadoFinded = findById(id);
        associadoFinded = this.objectMapper.convertValue(associadoDtoIn, Associado.class);
        associadoFinded.setIdAssociado(id);
        return this.objectMapper.convertValue(
                this.associadoRepository.save(associadoFinded),
                    AssociadoDtoOut.class
        );
    }
    public void deleteAssociado(Integer id){
        try {
            Associado associado = this.findById(id);
            this.associadoRepository.delete(associado);
        }catch (Exception ignore){}
    }
    public Associado findById(Integer id) throws NotFoundException{
        return this.associadoRepository.findById(id).orElseThrow(()-> new NotFoundException("Associado not Found"));
    }
    public Associado findAssociadoByCpf(String cpf) throws NotFoundException{

        return this.associadoRepository.findByCpf(cpf).orElseThrow(()-> new NotFoundException("Associado not Found"));
    }
}