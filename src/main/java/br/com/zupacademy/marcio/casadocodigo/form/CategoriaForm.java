package br.com.zupacademy.marcio.casadocodigo.form;

import br.com.zupacademy.marcio.casadocodigo.modelo.Categoria;
import br.com.zupacademy.marcio.casadocodigo.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @Column(unique = true)
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter(CategoryRepository categoryRepository){
        return new Categoria(nome);
    }
}
