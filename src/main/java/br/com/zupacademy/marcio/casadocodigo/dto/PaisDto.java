package br.com.zupacademy.marcio.casadocodigo.dto;

import br.com.zupacademy.marcio.casadocodigo.modelo.Pais;

import java.util.List;
import java.util.stream.Collectors;

public class PaisDto {

    private String nome;

    @Deprecated
    public PaisDto(){
    }

    public PaisDto(Pais pais) {
        this.nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }

    public static List<PaisDto> converter(List<Pais> pais){
        return pais.stream().map(PaisDto::new).collect(Collectors.toList());
    }
}
