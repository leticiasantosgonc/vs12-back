package br.com.dbc.vemser.produtorconsumidor.service;

import br.com.dbc.vemser.produtorconsumidor.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumidorService {

    private final ObjectMapper objectMapper;

    @KafkaListener(
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0"})},
            clientIdPrefix = "geral"
    )
    public void consumeWhatsApp(@Payload String mensagem,
                                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Long partition) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("ENVIAR WHATSAPP COM A SEGUINTE MSG: " + mensagemDTO);
    }

    @KafkaListener(
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"13"})},
            clientIdPrefix = "privado"
    )
    public void consumeWhatsAppPrivate(@Payload String mensagem,
                                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Long partition) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("ENVIAR WHATSAPP COM A SEGUINTE MSG: " + mensagemDTO);
    }

}
