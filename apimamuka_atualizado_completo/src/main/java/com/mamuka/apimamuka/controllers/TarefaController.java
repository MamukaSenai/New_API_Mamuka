package com.mamuka.apimamuka.controllers;

import com.mamuka.apimamuka.dtos.TarefaDto;
import com.mamuka.apimamuka.models.TarefaModel;
import com.mamuka.apimamuka.repositories.ProjetoRepository;
import com.mamuka.apimamuka.repositories.TarefaRepository;
import com.mamuka.apimamuka.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/tarefas", produces = {"application/json"})
public class TarefaController {
    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> listarTarefas(){
        return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findAll());

    }

    @GetMapping("/{idTarefa}")
    public ResponseEntity<Object> exibirtarefa(@PathVariable(value = "idTarefa")UUID id) {
        Optional<TarefaModel> tarefaBuscada = tarefaRepository.findById(id);

        if (tarefaBuscada.isEmpty()) {
            // Retornar servico não encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tarefaBuscada.get());
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarTarefa(@RequestBody @Valid TarefaDto tarefaDto) {
        TarefaModel tarefaModel = new TarefaModel();

        BeanUtils.copyProperties(tarefaDto, tarefaModel);

        var projeto = projetoRepository.findById(tarefaDto.id_projeto());

        if (projeto.isPresent()) {
            tarefaModel.setProjeto(projeto.get());
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id_projeto não encontrado");
        }

        var dev = usuarioRepository.findById(tarefaDto.id_responsavel());

        if (dev.isPresent()) {
            tarefaModel.setDev(dev.get());
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id_responsavel não encontrado");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefaModel));
    }
}
