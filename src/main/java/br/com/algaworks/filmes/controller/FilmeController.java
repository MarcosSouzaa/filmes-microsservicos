package br.com.algaworks.filmes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/filmes")
public class FilmeController {

//Para fazer a nossa lógica de negócios, representar a nossa camada de servíço, criei a camada FilmeService
    @Autowired //Injetei no nosso controlador
    private FilmeService filmeService;

//A ideia é que o método "obterFilme" funcione independente de como estiver funcionando o filmeService
//O que quero testar é essa unidade de código abaixo

    @GetMapping("/{codigo}")
    public ResponseEntity<Filme> obterFilme(@PathVariable Long codigo){

        Filme filme = this.filmeService.obterFilme(codigo); //Daqui que vou obter os dados do filme
                                                           // poderia ser de um db
        if(filme == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filme);
    }
}

//Não está usando o banco de dados
//Filme está fixo