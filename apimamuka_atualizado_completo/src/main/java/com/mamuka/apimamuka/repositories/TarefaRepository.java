package com.mamuka.apimamuka.repositories;

import com.mamuka.apimamuka.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface TarefaRepository extends JpaRepository<TarefaModel, UUID> {
}
