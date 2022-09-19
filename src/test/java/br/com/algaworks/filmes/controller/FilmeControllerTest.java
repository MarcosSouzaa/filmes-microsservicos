package br.com.algaworks.filmes.controller;


import br.com.algaworks.filmes.model.Filme;
import br.com.algaworks.filmes.service.FilmeService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest //vai rodar dentro de um contexto web
public class FilmeControllerTest {

    @Autowired //implementacao real
    private FilmeController filmeController;

    @MockBean  //Nao injeta o objeto real na hora que a aplicacao sobe, cria falso. Especificamos o que ele devolve
    private FilmeService filmeService;

    @BeforeEach
    public void setUp() {
        standaloneSetup(this.filmeController);
    }

    @Test
     void deveRetornarSucesso_QuandoBuscarFilme() {

        Mockito.when(this.filmeService.obterFilme(1L))
                  .thenReturn(new Filme(1L, "O Poderoso Chefão","Sem descrição"));

            given()                                             //Dado uma informacao
                  .accept(ContentType.JSON)                       //Dado esse reader(leitor) ContentType Json
           .when()                                             // Quando Fizer um GET (Uma Requisicao)
                  .get("/filmes/{codigo}", 1L)    // faca um um get em /filmes/{codigo} cujo codigo e 1
           .then()                                             //Quando chegar essa requisicao, entao
                  .statusCode(HttpStatus.OK.value());              //O statusCode deve ser OK, 200 O STATUS DE SUCESSO.
                                                            // ele espera um valor int, por isso foi usado .value
                                                            // o statusCode é um ENUM
    }
}