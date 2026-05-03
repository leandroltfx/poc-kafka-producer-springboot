package br.com.poc_1_kafka_cadastro_pedido_ms_springboot.dto;

import java.math.BigDecimal;
import java.util.List;

public record CadastroPedidoRequestDTO(
        List<String> itens,
        BigDecimal valor
) {
}
