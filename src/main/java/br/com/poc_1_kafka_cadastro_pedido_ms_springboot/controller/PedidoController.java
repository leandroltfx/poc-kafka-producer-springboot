package br.com.poc_1_kafka_cadastro_pedido_ms_springboot.controller;

import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.dto.ApiResponseDTO;
import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.dto.CadastroPedidoRequestDTO;
import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.useCase.CadastroPedidoUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
@Slf4j
public class PedidoController {

    private final CadastroPedidoUseCase cadastroPedidoUseCase;

    @PostMapping
    public ResponseEntity<ApiResponseDTO> cadastrarPedido(
            @RequestBody CadastroPedidoRequestDTO cadastroPedidoRequestDTO
    ) {
        log.info("Requisição para cadastro de pedido recebida.");
        cadastroPedidoUseCase.execute(cadastroPedidoRequestDTO);
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO("Pedido cadastrado com sucesso!");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apiResponseDTO);
    }

}
