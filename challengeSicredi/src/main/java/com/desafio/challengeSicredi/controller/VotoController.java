package com.desafio.challengeSicredi.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.desafio.challengeSicredi.infra.docs.VotoControllerDoc;
import com.desafio.challengeSicredi.infra.exceptions.NotFoundException;
import com.desafio.challengeSicredi.infra.exceptions.NotOpenedSession;
import com.desafio.challengeSicredi.model.entity.Voto;
import com.desafio.challengeSicredi.model.enums.ConteudoVoto;
import com.desafio.challengeSicredi.model.service.VotoService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voto")
@RequiredArgsConstructor
public class VotoController implements VotoControllerDoc {

    private final VotoService votoService;

    @PostMapping("/{cpf}/{idSessao}")
    public ResponseEntity<Voto> createVoto(@PathVariable ("cpf") @Pattern(regexp = "^[0-9]{11}$",message = "Insira um cpf válido")String cpf,
                                          @PathVariable("idSessao") Integer idSessao,
                                          @RequestParam ConteudoVoto conteudoVoto) throws NotFoundException, NotOpenedSession {


        return new ResponseEntity<>(this.votoService.createVoto(cpf,idSessao,conteudoVoto), HttpStatus.CREATED);
    }

}
