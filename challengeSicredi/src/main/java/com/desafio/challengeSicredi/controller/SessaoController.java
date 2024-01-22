package com.desafio.challengeSicredi.controller;

import com.desafio.challengeSicredi.infra.docs.SessaoControllerDoc;
import com.desafio.challengeSicredi.infra.exceptions.NotFoundException;
import com.desafio.challengeSicredi.model.dto.RelatorioVotosSessao;
import com.desafio.challengeSicredi.model.dto.SessaoDtoIn;
import com.desafio.challengeSicredi.model.dto.SessaoDtoOut;
import com.desafio.challengeSicredi.model.entity.Sessao;
import com.desafio.challengeSicredi.model.service.SessaoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessao")
@RequiredArgsConstructor
public class SessaoController implements SessaoControllerDoc {

    private final SessaoService sessaoService;

    @Override
    @GetMapping
    public ResponseEntity<List<Sessao>> getAllSession(){
        return new ResponseEntity<>(this.sessaoService.getAllSession(), HttpStatus.OK);
    }
    @Override
    @PostMapping("/{idPauta}")
    public ResponseEntity<SessaoDtoOut> createSessao(@RequestBody @Valid SessaoDtoIn sessaoDtoIn,
                                                     @PathVariable ("idPauta") @Positive Integer idPauta)throws NotFoundException {
        return new ResponseEntity<>(this.sessaoService.createSessao(sessaoDtoIn, idPauta),HttpStatus.CREATED);
    }

    @GetMapping("{idSessao}")
    public  ResponseEntity<RelatorioVotosSessao> findRelatorioSessao(@PathVariable("idSessao")Integer idSessao) throws NotFoundException{
        return new ResponseEntity<>(this.sessaoService.relatorioVotosSessao(idSessao),HttpStatus.OK);
    }

}
