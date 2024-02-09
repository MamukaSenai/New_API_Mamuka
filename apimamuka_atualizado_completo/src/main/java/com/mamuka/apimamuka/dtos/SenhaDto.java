package com.mamuka.apimamuka.dtos;

import jakarta.validation.constraints.NotBlank;

public record SenhaDto(
        @NotBlank String senha
){}
