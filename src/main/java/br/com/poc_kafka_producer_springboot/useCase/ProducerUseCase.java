package br.com.poc_kafka_producer_springboot.useCase;

import br.com.poc_kafka_producer_springboot.dto.ProducerDTO;
import br.com.poc_kafka_producer_springboot.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerUseCase {

    private final KafkaProducer kafkaProducer;

    public void execute(
            ProducerDTO producerDTO
    ) {
        kafkaProducer.publish(producerDTO);
    }

}
