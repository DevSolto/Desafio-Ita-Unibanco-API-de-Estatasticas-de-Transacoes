package com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.business.services;

import com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.controllers.dtos.TransactionRequestDTO;
import com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.infrastructure.excepions.UnprocessableEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {
    private final List<TransactionRequestDTO> transactionList;

    public void addTransaction(TransactionRequestDTO transaction){

        log.info("Iniciado o processo de gravar transacao");

        if(transaction.dataHora().isAfter(OffsetDateTime.now())){
            log.error("Data e hora maiores que a data e hora atual.");
            throw new UnprocessableEntity("Data e hora maiores que a data e hora atual.");
        }

        if(transaction.valor()<0){
            log.error("Valor negativo");
            throw new UnprocessableEntity("Valor negativo");
        }

        transactionList.add(transaction);
        log.info("Transacao adicionada");
    }

    public void clearTransactions(){
        transactionList.clear();
        log.info("Transacoes deletadas");
    }

    public List<TransactionRequestDTO> getTransactionList(int seconds ) {
        OffsetDateTime dateTimeInterval = OffsetDateTime.now().minusSeconds(seconds);
        return transactionList.stream().filter(transactionRequestDTO -> transactionRequestDTO.dataHora().isAfter(dateTimeInterval)).toList();
    }
}
