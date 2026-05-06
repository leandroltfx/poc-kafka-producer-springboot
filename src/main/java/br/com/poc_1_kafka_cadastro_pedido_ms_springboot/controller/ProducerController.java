package br.com.poc_1_kafka_cadastro_pedido_ms_springboot.controller;

import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.dto.ApiResponseDTO;
import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.dto.ProducerDTO;
import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.useCase.ProducerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerUseCase producerUseCase;

    @PostMapping
    public ResponseEntity<ApiResponseDTO> producer(
            @RequestBody ProducerDTO producerDTO
    ) {
        producerUseCase.execute(producerDTO);
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO("Pedido cadastrado com sucesso!");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apiResponseDTO);
    }

}
