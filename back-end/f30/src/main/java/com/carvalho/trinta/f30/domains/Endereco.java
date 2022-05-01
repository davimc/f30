package com.carvalho.trinta.f30.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //caso o cliente queira salvar com o nome do local(favoritos)
    private String nome;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String referência;
    private String CEP;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(String logradouro, String bairro, String numero, String complemento, String referência, String CEP, Cliente cliente) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.referência = referência;
        this.CEP = CEP;
        this.cliente = cliente;
    }

    public Endereco(String nome, String logradouro, String bairro, String numero, String complemento, String referência, String CEP, Cliente cliente) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.referência = referência;
        this.CEP = CEP;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferência() {
        return referência;
    }

    public void setReferência(String referência) {
        this.referência = referência;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
