package br.com.zupacademy.marcio.casadocodigo.modelo;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(length = 400)
    private String descricao;

    private Instant dataRegistro = Instant.now();


    public Autor(String nome, String email, String descricao ) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return email;
    }

 }
