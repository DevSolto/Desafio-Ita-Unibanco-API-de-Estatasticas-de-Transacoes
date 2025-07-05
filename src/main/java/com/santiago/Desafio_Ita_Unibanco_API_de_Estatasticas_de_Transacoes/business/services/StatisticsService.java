package com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.business.services;

import com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.controllers.dtos.StatisticRequestDTO;
import com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.controllers.dtos.TransactionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final TransactionService transactionService;

    public StatisticRequestDTO calculateStatistics(int seconds){
        var transactions = transactionService.getTransactionList(seconds);

        var statistics = transactions.stream().mapToDouble(TransactionRequestDTO::valor).summaryStatistics();

        return  new StatisticRequestDTO(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMin(),
                statistics.getMax()
        );
    }




}
