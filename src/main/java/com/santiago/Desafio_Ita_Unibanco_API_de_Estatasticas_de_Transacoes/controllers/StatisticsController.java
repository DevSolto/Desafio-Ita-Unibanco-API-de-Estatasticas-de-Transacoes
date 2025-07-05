package com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.controllers;

import com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.business.services.StatisticsService;
import com.santiago.Desafio_Ita_Unibanco_API_de_Estatasticas_de_Transacoes.controllers.dtos.StatisticRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping
    public ResponseEntity<StatisticRequestDTO> getStatistics(
            @RequestParam(
                    value = "seconds",
                    required = false,
                    defaultValue = "60"
            ) int seconds
    ){
    return ResponseEntity.ok(statisticsService.calculateStatistics(seconds));
    }
}
