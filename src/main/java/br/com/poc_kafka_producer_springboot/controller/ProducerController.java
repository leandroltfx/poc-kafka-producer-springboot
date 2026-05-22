package br.com.poc_kafka_producer_springboot.controller;

import br.com.poc_kafka_producer_springboot.dto.ApiResponseDTO;
import br.com.poc_kafka_producer_springboot.dto.ProducerDTO;
import br.com.poc_kafka_producer_springboot.useCase.ProducerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerUseCase producerUseCase;

    @PostMapping
    public ResponseEntity<ApiResponseDTO> producer(
            @RequestBody ProducerDTO producerDTO
    ) {
        producerUseCase.execute(producerDTO);
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO("Mensagem enviada com sucesso!");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apiResponseDTO);
    }

}
