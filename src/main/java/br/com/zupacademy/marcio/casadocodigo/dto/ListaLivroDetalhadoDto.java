package br.com.zupacademy.marcio.casadocodigo.dto;

import br.com.zupacademy.marcio.casadocodigo.modelo.Livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class ListaLivroDetalhadoDto {


    private String titulo;
    private String isbn;
    private int numeroPaginas;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private String dataPublicacao;
    private AutorReduzidoDto autor;
    private CategoriaDto categoria;

    public ListaLivroDetalhadoDto(Livro livro) {
        titulo = livro.getTitulo();
        isbn = livro.getIsbn();
        numeroPaginas = livro.getNumeroPaginas();
        preco = livro.getPreco();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        dataPublicacao = livro.getDataDePublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        autor = new AutorReduzidoDto(livro.getAutor());
        categoria = new CategoriaDto(livro.getCategoria());


               // (DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorReduzidoDto getAutor() {
        return autor;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }
}
