package br.com.zupacademy.marcio.casadocodigo.form;

import br.com.zupacademy.marcio.casadocodigo.modelo.Estado;
import br.com.zupacademy.marcio.casadocodigo.modelo.Pais;
import br.com.zupacademy.marcio.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.marcio.casadocodigo.validator.ExistId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoForm {

    @NotBlank
    private String nome;

    @NotNull
    @ExistId(domainClass = Pais.class, fieldName = "id")
    private Pais pais;

    public EstadoForm(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado converter(PaisRepository paisRepository){

        Pais pais = paisRepository.getById(getPais().getId());

        return new Estado(nome, pais);
    }
}
