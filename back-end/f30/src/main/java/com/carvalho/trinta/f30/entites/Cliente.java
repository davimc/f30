package com.carvalho.trinta.f30.entites;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String whatsapp;
    private String telefone;

    @Temporal(TemporalType.DATE)
    private Calendar dataCadastro;

    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    //TODO configurar endereço e webservice de cep
    // - rua
    // - bairro
    // - numero
    // - complemento
    // - referência
    // - CEP

    public Cliente() {
    }

    public Cliente(String nome, String whatsapp, String telefone, Calendar dataCadastro) {
        this.nome = nome;
        this.whatsapp = whatsapp;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
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

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
