package br.com.dbc.vemser.produtorconsumidor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    @KafkaListener(
            topics = "meu-primeiro-topico",
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "primeiroTopico")
    public void consume(String mensagem){
        System.out.println("Mensagem enviada:"+mensagem);
    }
}
