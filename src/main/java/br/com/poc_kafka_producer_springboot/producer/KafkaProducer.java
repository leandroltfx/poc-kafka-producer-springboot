package br.com.poc_kafka_producer_springboot.producer;

import br.com.poc_kafka_producer_springboot.dto.ProducerDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${config.kafka.topics.poc-1-messages}")
    private String topico;

    public void publish(
            ProducerDTO producerDTO
    ) {

        log.info("Publicando mensagem...");

        try {
            var json = objectMapper.writeValueAsString(producerDTO);
            kafkaTemplate.send(topico, "pedidos", json);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("Erro ao processar o json da mensagem", jsonProcessingException);
        } catch (RuntimeException runtimeException) {
            log.error("Erro técnico ao publicar a mensagem", runtimeException);
        }
    }

}
