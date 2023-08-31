package br.com.dbc.vemser.produtorconsumidor.controller;

import br.com.dbc.vemser.produtorconsumidor.dto.EnvioEnum;
import br.com.dbc.vemser.produtorconsumidor.dto.MensagemDTO;
import br.com.dbc.vemser.produtorconsumidor.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;

    @Value("${kafka.client-id}")
    private String clientId;

    @PostMapping("/enviar-mensagem")
    private void enviar(String msg, @RequestParam("envios") List<EnvioEnum> envios) throws JsonProcessingException {
        for (EnvioEnum envioEnum : envios){
            MensagemDTO mensagemDTO = new MensagemDTO(clientId, msg, LocalDateTime.now());
            produtorService.enviarMensagem(mensagemDTO, envioEnum.ordinal());
        }
    }
}

