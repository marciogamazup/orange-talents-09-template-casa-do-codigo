package br.com.zupacademy.marcio.casadocodigo.form;

import br.com.zupacademy.marcio.casadocodigo.modelo.Autor;
import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converter(AutorRepository autorRepository) {
        return new Autor(nome, email, descricao);
    }
}
