package com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.controllers.dtos;

public record StatisticRequestDTO(
        long cont,
        Double sum,
        Double avg,
        Double mim,
        Double max
) {
}
