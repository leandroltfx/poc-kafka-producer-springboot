package br.com.poc_1_kafka_cadastro_pedido_ms_springboot.useCase;

import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.dto.CadastroPedidoRequestDTO;
import br.com.poc_1_kafka_cadastro_pedido_ms_springboot.publisher.PedidoPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CadastroPedidoUseCase {

    private final PedidoPublisher pedidoPublisher;

    public void execute(
            CadastroPedidoRequestDTO cadastroPedidoRequestDTO
    ) {
        log.info("Iniciando cadastro de pedido");

        // persistência do pedido na base de dados...
        log.info("Pedido inserido na base de dados");

        pedidoPublisher.publicar(cadastroPedidoRequestDTO);
    }

}
