package com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.controllers.dtos;

import java.time.OffsetDateTime;

public record TransactionRequestDTO(Double valor, OffsetDateTime dataHora) {

}
