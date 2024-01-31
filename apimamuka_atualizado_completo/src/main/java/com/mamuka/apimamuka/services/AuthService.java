package com.mamuka.apimamuka.services;

import com.mamuka.apimamuka.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = usuarioRepository.findByEmail(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        return usuario;
    }


    //PARA CRIAR METODO PARA BUSCA POR NOME
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        var nomeUsuario = usuarioRepository.findByName(name);
//
//        if (nomeUsuario == null) {
//            throw new UsernameNotFoundException("Usuário não encontrado!");
//        }
//
//        return nomeUsuario;
//    }
}
