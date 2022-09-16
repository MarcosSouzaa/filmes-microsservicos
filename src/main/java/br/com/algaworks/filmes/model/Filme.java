package br.com.algaworks.filmes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Filme {

    private Long codigo;
    private String titulo;
    private String descricao;
}

// está retornando um filme fixo na camada service
// Criei o Model Filme utilizando o lombok para os construtores
// Ele tem codigo,título e descrição
