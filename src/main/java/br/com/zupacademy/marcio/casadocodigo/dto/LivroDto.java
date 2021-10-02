package br.com.zupacademy.marcio.casadocodigo.dto;

import br.com.zupacademy.marcio.casadocodigo.modelo.Autor;
import br.com.zupacademy.marcio.casadocodigo.modelo.Categoria;
import br.com.zupacademy.marcio.casadocodigo.modelo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LivroDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numeroPaginas;
    private String isbn;
    private LocalDate dataDePublicacao;
    private Autor autor;
    private Categoria categoria;

    public LivroDto() {
    }
    public LivroDto(Livro livro) {
        this.titulo = livro.getTitulo();

        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataDePublicacao = livro.getDataDePublicacao();
        this.autor = livro.getAutor();
        this.categoria = livro.getCategoria();
    }

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

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public static List<LivroDto> converter(List<Livro> livros) {
        return livros.stream().map(LivroDto::new).collect(Collectors.toList());
    }
}
