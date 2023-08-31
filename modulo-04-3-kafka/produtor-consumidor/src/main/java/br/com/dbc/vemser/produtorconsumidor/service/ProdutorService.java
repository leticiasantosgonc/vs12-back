package br.com.dbc.vemser.produtorconsumidor.service;

import br.com.dbc.vemser.produtorconsumidor.dto.EnvioEnum;
import br.com.dbc.vemser.produtorconsumidor.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic}")
    private String topic;

    public void enviarMensagem(MensagemDTO mensagemDTO, Integer particao) throws JsonProcessingException {
        String payload = objectMapper.writeValueAsString(mensagemDTO);
        Message<String> message = MessageBuilder.withPayload (payload)
                .setHeader (KafkaHeaders. TOPIC, topic)
                .setHeader (KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .setHeader(KafkaHeaders.PARTITION_ID, particao)
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sucesso ao enviar log com texto ao kafka");
            }
            @Override
            public void onFailure(Throwable ex) {
                log.error("Erro ao enviar log com texto ao kafka");
            }
        });
    }
}
