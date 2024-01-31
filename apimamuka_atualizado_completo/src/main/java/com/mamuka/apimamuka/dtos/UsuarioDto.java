package com.mamuka.apimamuka.dtos;

import com.mamuka.apimamuka.models.TipoModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record UsuarioDto (
        TipoModel tipo_usuario,
        @NotBlank String nome,
        @NotBlank String cpf,
        Date dataNascimento,
        Boolean statusAtividade,
        String departamento,
//        String responsavel,
        String perfil,
        String cargo,
        @NotBlank @Email(message = " O email deve estar em um formato valido ") String email,

        @NotBlank String senha

){
}
