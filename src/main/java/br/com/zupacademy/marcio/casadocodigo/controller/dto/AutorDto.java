package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.modelo.Autor;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class AutorDto {

    private Integer id;
    private String nome;
    private String email;
    private String descricao;

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return email;
    }

    public static List<AutorDto> converter(List<Autor> autores) {
        return autores.stream().map(AutorDto::new).collect(Collectors.toList());
    }
}
