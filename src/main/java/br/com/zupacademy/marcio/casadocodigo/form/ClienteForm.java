package br.com.zupacademy.marcio.casadocodigo.form;

import br.com.zupacademy.marcio.casadocodigo.modelo.Cliente;
import br.com.zupacademy.marcio.casadocodigo.modelo.Estado;
import br.com.zupacademy.marcio.casadocodigo.modelo.Pais;
import br.com.zupacademy.marcio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.marcio.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.marcio.casadocodigo.validator.CpfCnpj;
import br.com.zupacademy.marcio.casadocodigo.validator.UniqueValue;
import br.com.zupacademy.marcio.casadocodigo.validator.ValidDocumento;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteForm {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    @CpfCnpj
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @NotNull
    private Pais pais;

    private Estado estado;

    @Deprecated
    public ClienteForm(){
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {

        Pais pais = paisRepository.getById(getPais().getId());
        Estado estado = estadoRepository.getById((getEstado().getId()));
        return new Cliente (email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, pais, estado);
    }
}

//        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, telefone, cep, pais, estado);

