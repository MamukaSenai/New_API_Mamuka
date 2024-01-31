package com.mamuka.apimamuka.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public record TarefaDto(
        @NotNull UUID id_responsavel,
        @NotNull UUID id_projeto,
        @NotBlank String nome_tarefa,
        @NotBlank String status_tarefa,
        @NotNull Date data_inicio,
        @NotNull Date data_conclusao
) {
}
