package br.com.poc_1_kafka_cadastro_pedido_ms_springboot.useCase;

import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.dto.ProducerDTO;
import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerUseCase {

    private final KafkaProducer kafkaProducer;

    public void execute(
            ProducerDTO producerDTO
    ) {
        kafkaProducer.publicar(producerDTO);
    }

}
