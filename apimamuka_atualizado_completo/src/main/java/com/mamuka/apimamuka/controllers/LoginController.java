package com.mamuka.apimamuka.controllers;

import com.mamuka.apimamuka.dtos.LoginDto;
import com.mamuka.apimamuka.dtos.TokenDto;
import com.mamuka.apimamuka.models.UsuarioModel;
import com.mamuka.apimamuka.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto dados) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.email(),dados.senha());

        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.gerarToken((UsuarioModel) auth.getPrincipal());

        UsuarioModel usuario = (UsuarioModel) auth.getPrincipal();

        return ResponseEntity.status(HttpStatus.OK).body(new TokenDto(token, usuario.getId()));
    }
}
