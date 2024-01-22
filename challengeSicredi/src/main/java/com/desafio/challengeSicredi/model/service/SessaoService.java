package com.desafio.challengeSicredi.model.service;
import com.desafio.challengeSicredi.infra.exceptions.NotFoundException;
import com.desafio.challengeSicredi.infra.exceptions.NotOpenedSession;
import com.desafio.challengeSicredi.model.dto.RelatorioVotosDto;
import com.desafio.challengeSicredi.model.dto.RelatorioVotosSessao;
import com.desafio.challengeSicredi.model.dto.SessaoDtoIn;
import com.desafio.challengeSicredi.model.dto.SessaoDtoOut;
import com.desafio.challengeSicredi.model.entity.Pauta;
import com.desafio.challengeSicredi.model.entity.Sessao;
import com.desafio.challengeSicredi.model.entity.Voto;
import com.desafio.challengeSicredi.model.enums.StatusSessao;
import com.desafio.challengeSicredi.model.repository.SessaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SessaoService {


    private final SessaoRepository sessaoRepository;
    private final PautaService pautaService;
    private final ObjectMapper objectMapper;

    public List<Sessao> getAllSession(){

        return this.sessaoRepository.findAll();
    }
    public SessaoDtoOut createSessao(SessaoDtoIn sessaoDtoIn, Integer idPauta) throws NotFoundException {
        Pauta pautaFinded = this.pautaService.findByid(idPauta);

        LocalDateTime inicioDate = LocalDateTime.now();
        Timestamp inicioDateTimestamp = parsedInicioDate(inicioDate);

        int duracao = 1;
        if (sessaoDtoIn.getTempoDuracao() != 1) {
            duracao = sessaoDtoIn.getTempoDuracao();
        }
        Timestamp finalDateTimestamp =parsedFinalDate(inicioDate,duracao);

        Sessao sessaoToSave = new Sessao();
        sessaoToSave.setPauta(pautaFinded);
        sessaoToSave.setStatusSessao(StatusSessao.O);
        sessaoToSave.setInicioDate(inicioDateTimestamp);
        sessaoToSave.setTempoDuracao(duracao);
        sessaoToSave.setFinalDate(finalDateTimestamp);

        return this.objectMapper.convertValue(
                this.sessaoRepository.save(sessaoToSave),SessaoDtoOut.class);

    }

    public RelatorioVotosSessao relatorioVotosSessao(Integer idSessao) throws NotFoundException{

        Sessao sessaoFinded = this.findById(idSessao);

        List<Voto> votosSessao = sessaoFinded.getVotos();

        List<RelatorioVotosDto> votosSessaoDto = votosSessao.stream().map(this::convertVotoToVotoDto).toList();

        RelatorioVotosSessao relatorioVotosSessao = new RelatorioVotosSessao();
        relatorioVotosSessao.setFinalSessao(sessaoFinded.getFinalDate());
        relatorioVotosSessao.setIdSessao(sessaoFinded.getIdSessao());
        relatorioVotosSessao.setQtdVotos(votosSessaoDto.size());
        relatorioVotosSessao.setRelatorioVotosDto(votosSessaoDto);

        return relatorioVotosSessao;

    }
    public RelatorioVotosDto convertVotoToVotoDto(Voto voto){
        RelatorioVotosDto relatorioVotosDto = new RelatorioVotosDto();
        relatorioVotosDto.setConteudoVoto(voto.getConteudoVoto());
        relatorioVotosDto.setInfoVoto(voto.getInfoVoto());
        relatorioVotosDto.setIdAssociado(voto.getAssociado().getIdAssociado());
        relatorioVotosDto.setIdVoto(voto.getIdVoto());

        return relatorioVotosDto;
    }

    private Timestamp parsedInicioDate(LocalDateTime inicioDate){
        long millisInicio = inicioDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return new Timestamp(millisInicio);
    }
    private Timestamp parsedFinalDate(LocalDateTime inicioDate,int duracao){
        LocalDateTime finalDate = inicioDate.plusMinutes(duracao);
        long millis =  finalDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return  new Timestamp(millis);
    }
    public void verifySessaoStatus(Integer idSessao) throws NotOpenedSession,NotFoundException{
        Sessao sessaoFinded = this.sessaoRepository.findById(idSessao).orElseThrow(()->new NotFoundException("Sessao not Found"));

        if(sessaoFinded.getStatusSessao() == StatusSessao.O){
            LocalDateTime atual = LocalDateTime.now();
            long millis = atual.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            Timestamp nowTime = new Timestamp(millis);

            int compareToTimes = nowTime.compareTo(sessaoFinded.getFinalDate());

            if(compareToTimes >= 0){
                sessaoFinded.setStatusSessao(StatusSessao.C);
                this.sessaoRepository.save(sessaoFinded);
                throw new NotOpenedSession ("Session Closed");
            }

            return;

        }
        throw new NotOpenedSession("Session Closed");
    }
    public Sessao findById(Integer idSessao) throws NotFoundException{

        return this.sessaoRepository.findById(idSessao)
                .orElseThrow(()-> new NotFoundException(" Sessao not Found"));
    }

    @Scheduled(fixedRate = 3000)
    public void verificarSessões(){

        System.out.println(LocalDateTime.now() + "Executando verificação de sessões !");
        List<Sessao> sessoes = this.sessaoRepository.findAll();

        if(!sessoes.isEmpty()){

            for (Sessao sessao: sessoes) {

                if(sessao.getStatusSessao() == StatusSessao.O){

                    LocalDateTime atual = LocalDateTime.now();
                    long millis = atual.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    Timestamp nowTime = new Timestamp(millis);

                    int compareToTimes = nowTime.compareTo(sessao.getFinalDate());

                    if(compareToTimes >= 0){
                        sessao.setStatusSessao(StatusSessao.C);
                        this.sessaoRepository.save(sessao);

                    }
                }
            }
        }
    }
}
