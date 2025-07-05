package com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.controllers;

import com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.business.services.TransactionService;
import com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.controllers.dtos.TransactionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransactionsController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> postTransaction(@RequestBody TransactionRequestDTO transaction){
        transactionService.addTransaction(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransactions(){
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}
