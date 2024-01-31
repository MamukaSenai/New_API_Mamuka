package com.mamuka.apimamuka.dtos;

import java.util.UUID;

public record TokenDto(
        String token,
        UUID idUsuario

) {
}
