package br.com.zupacademy.marcio.casadocodigo.dto;

import br.com.zupacademy.marcio.casadocodigo.modelo.Autor;

import java.util.List;
import java.util.stream.Collectors;

public class AutorReduzidoDto {

    private String nome;
    private String descricao;

    @Deprecated
    public AutorReduzidoDto(){
    }

    public AutorReduzidoDto(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
