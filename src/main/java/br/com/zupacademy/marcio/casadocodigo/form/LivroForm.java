package br.com.zupacademy.marcio.casadocodigo.form;

import br.com.zupacademy.marcio.casadocodigo.modelo.Autor;
import br.com.zupacademy.marcio.casadocodigo.modelo.Categoria;
import br.com.zupacademy.marcio.casadocodigo.modelo.Livro;
import br.com.zupacademy.marcio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.marcio.casadocodigo.repository.CategoryRepository;
import br.com.zupacademy.marcio.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private int numeroPaginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy",shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Instant dataDePublicacao;
//    @Valid
    @NotNull
    private Autor autor;
//    @Valid
    @NotNull
    private Categoria categoria;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public Instant getDataDePublicacao() {
        return dataDePublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public Livro converter(AutorRepository autorRepository, CategoryRepository categoryRepository){

        Categoria categoria = categoryRepository.getById(getCategoria().getId());
        Autor autor = autorRepository.getById(getAutor().getId());

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataDePublicacao, autor, categoria);
    }
}
