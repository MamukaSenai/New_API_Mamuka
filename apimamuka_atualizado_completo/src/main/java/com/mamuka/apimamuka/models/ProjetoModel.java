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
@Table(name = "tb_projeto")
public class ProjetoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_gestor", referencedColumnName = "id")
    private UsuarioModel gestor ;

    private String nome_projeto;

    private String status_projeto;

//    private String responsavel;

    private String data_inicio;

    private String data_conclusao;

//    @Temporal(TemporalType.DATE)
//    private Date data_inicio; // VERFICAR O TIPO DA VARIAVEL

//    @Temporal(TemporalType.DATE)
//    private Date data_conclusao; // VERFICAR O TIPO DA VARIAVEL

}