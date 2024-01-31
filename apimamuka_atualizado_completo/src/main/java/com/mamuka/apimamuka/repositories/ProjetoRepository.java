package com.mamuka.apimamuka.repositories;

import com.mamuka.apimamuka.models.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface ProjetoRepository extends JpaRepository<ProjetoModel, UUID> {
}

