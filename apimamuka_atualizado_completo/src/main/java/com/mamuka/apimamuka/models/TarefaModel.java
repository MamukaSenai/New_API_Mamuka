package com.mamuka.apimamuka.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_tarefa")
public class TarefaModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_responsavel", referencedColumnName = "id")
    //    private UUID id_dev ;
    private UsuarioModel dev ;

    @ManyToOne
    @JoinColumn(name = "id_projeto", referencedColumnName = "id")
    //    private UUID id_projeto ;
    private ProjetoModel projeto ;

    private String nome_tarefa;
    private String status_tarefa;

    @Temporal(TemporalType.DATE)
    private Date data_inicio; // VERFICAR O TIPO DA VARIAVEL

    @Temporal(TemporalType.DATE)
    private Date data_conclusao; // VERFICAR O TIPO DA VARIAVEL
}