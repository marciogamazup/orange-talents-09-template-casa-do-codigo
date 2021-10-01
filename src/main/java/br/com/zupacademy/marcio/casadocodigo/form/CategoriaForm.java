package br.com.zupacademy.marcio.casadocodigo.form;

import br.com.zupacademy.marcio.casadocodigo.modelo.Categoria;
import br.com.zupacademy.marcio.casadocodigo.repository.CategoryRepository;
import br.com.zupacademy.marcio.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

//    public Categoria converter(){
//
//        return new Categoria(nome);
//    }
    public Categoria converter(CategoryRepository categoryRepository){
        return new Categoria(nome);
    }
}
