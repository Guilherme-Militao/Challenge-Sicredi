package com.desafio.challengeSicredi.model.service;

import com.desafio.challengeSicredi.infra.exceptions.NotFoundException;
import com.desafio.challengeSicredi.infra.exceptions.NotOpenedSession;
import com.desafio.challengeSicredi.model.entity.Associado;
import com.desafio.challengeSicredi.model.entity.Sessao;
import com.desafio.challengeSicredi.model.entity.Voto;
import com.desafio.challengeSicredi.model.enums.ConteudoVoto;
import com.desafio.challengeSicredi.model.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class VotoService {

    private final SessaoService sessaoService;
    private final VotoRepository votoRepository;
    private final AssociadoService associadoService;


    public Voto createVoto(String cpf,Integer idSessao,ConteudoVoto content) throws NotFoundException, NotOpenedSession {


        Associado associadoFinded = this.associadoService.findAssociadoByCpf(cpf);

        Sessao sessaoFinded =this.sessaoService.findById(idSessao);

        this.sessaoService.verifySessaoStatus(sessaoFinded.getIdSessao());

        Timestamp infoVoto = new Timestamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        Voto votoToSave = new Voto();

        votoToSave.setAssociado(associadoFinded);
        votoToSave.setSessao(sessaoFinded);
        votoToSave.setConteudoVoto(content);
        votoToSave.setInfoVoto(infoVoto);

        return this.votoRepository.save(votoToSave);

    }
}
