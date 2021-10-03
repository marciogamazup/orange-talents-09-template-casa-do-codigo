package br.com.zupacademy.marcio.casadocodigo.form;

import br.com.zupacademy.marcio.casadocodigo.modelo.Pais;
import br.com.zupacademy.marcio.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais converter(){
      return new Pais(nome);
    }

}
