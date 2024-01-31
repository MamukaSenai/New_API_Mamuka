package com.mamuka.apimamuka.repositories;

import com.mamuka.apimamuka.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {
    UserDetails findByEmail(String email);


    //metodo para buscar por nome/ adicionei ao AuthService
    //UserDetails findByName(String nome)



}
