package br.com.zupacademy.marcio.casadocodigo.dto;

import br.com.zupacademy.marcio.casadocodigo.modelo.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class ListaLivrosDto {

    private Integer id;
    private String titulo;

    @Deprecated
    public ListaLivrosDto() {
    }

    public ListaLivrosDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<ListaLivrosDto> converter(List<Livro> livros){
        return livros.stream().map(ListaLivrosDto::new).collect(Collectors.toList());
    }
}
