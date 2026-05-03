package br.com.poc_1_kafka_cadastro_pedido_ms_springboot.publisher;

import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.dto.CadastroPedidoRequestDTO;
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
public class PedidoPublisher {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${config.kafka.topics.pedidos-criados}")
    private String topico;

    public void publicar(
            CadastroPedidoRequestDTO cadastroPedidoRequestDTO
    ) {

        log.info("Publicando pedido.");

        try {
            var json = objectMapper.writeValueAsString(cadastroPedidoRequestDTO);
            kafkaTemplate.send(topico, "pedidos", json);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("Erro ao processar o json do pedido criado", jsonProcessingException);
        } catch (RuntimeException runtimeException) {
            log.error("Erro técnico ao publicar pedido", runtimeException);
        }
    }

}
