package br.com.zupacademy.marcio.casadocodigo.dto;

import br.com.zupacademy.marcio.casadocodigo.modelo.Estado;
import br.com.zupacademy.marcio.casadocodigo.modelo.Pais;
import br.com.zupacademy.marcio.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class EstadoDto {

    @UniqueValue(domainClass = Estado.class,fieldName = "nome")
    private String nome;
    @NotNull
//    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Pais pais;

    @Deprecated
    public EstadoDto() {
    }

    public EstadoDto(Estado estado) {
        this.nome = estado.getNome();
        this.pais = estado.getPais();
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public static List<EstadoDto> converte (List<Estado> estados) {
        return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
    }
}
